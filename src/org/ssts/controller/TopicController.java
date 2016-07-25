package org.ssts.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssts.dao.StudentInfoDao;
import org.ssts.dao.TeacherInfoDao;
import org.ssts.dao.TopicInfoDao;
import org.ssts.dao.impl.StudentInfoDaoImpl;
import org.ssts.dao.impl.TeacherInfoDaoImpl;
import org.ssts.dao.impl.TopicInfoDaoImpl;
import org.ssts.entity.Student;
import org.ssts.entity.StudentInfo;
import org.ssts.entity.TeacherInfo;
import org.ssts.entity.TopicInfo;
import org.ssts.service.Page;
import org.ssts.service.Topic;
import org.ssts.service.impl.PageImpl;
import org.ssts.service.impl.TopicImpl;
import org.ssts.util.HibernateUtil;

import net.sf.json.JSONArray;

/**
 * 课题控制器，关于课题操作的类
 * 
 * @author 方曦
 *
 */
@Controller
public class TopicController {

	private Topic topic = new TopicImpl();
	private StudentInfoDao stuInfoDao = new StudentInfoDaoImpl();
	private TeacherInfoDao teaInfoDao = new TeacherInfoDaoImpl();
	private TopicInfoDao topicInfoDao = new TopicInfoDaoImpl();

	/**
	 * 查询全部课题
	 */
	@RequestMapping("/topicAll")
	public String querytopicAll(HttpServletRequest request) {
		Session session = HibernateUtil.getSession();
		String hql = "select new TopicInfo(t.topicId,t.topicTea,t.topicName,t.number,t.topicType,t.isSelectd) from TopicInfo as t order by topicTea asc";
		List<TopicInfo> topicInfos = topic.queryAllTopic(hql, session);
		request.setAttribute("user", HibernateUtil.USERNAME);
		request.setAttribute("topicAll", topicInfos);
		HibernateUtil.closeSession(session);
		return "index.jsp";
	}

	/**
	 * 选择课题，并更新数据库里的数据
	 */
	@Transactional//开启事务
	@RequestMapping("/selectTopic")
	public String selectTopic(StudentInfo stuInfo, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String stuQQ = request.getParameter("qq");
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		String stuTel = request.getParameter("tel");
		String grade = request.getParameter("grade");
		String stuNo = HibernateUtil.USERNO;
		int stuId = HibernateUtil.UERID;
		String hql1 = "from Student as stu where stu.userNo=?1";
		Student students = stuInfoDao.queryStudentById(hql1, session, stuId);
		TopicInfo topicInfos = topic.querySingleTopicById(session, topicId);

		String stuName = students.getUserName();
		String stuType = students.getStuType();
		String topicName = topicInfos.getTopicName();
		String topicTeacher = topicInfos.getTopicTea();

		stuInfo.setStuId(stuId);
		stuInfo.setStuNo(stuNo);
		stuInfo.setStuName(stuName);
		stuInfo.setStuGrade(grade);
		stuInfo.setStuTel(stuTel);
		stuInfo.setStuQQ(stuQQ);
		stuInfo.setStuType(stuType);
		stuInfo.setSelectedTopic(topicName);
		stuInfo.setSelectedTeacher(topicTeacher);
		stuInfo.setSelectedTime(new Date());
		stuInfoDao.addStuInfo(stuInfo, session); //添加学生选题信息

		System.out.println(stuInfo);

		String hql4 = "from TeacherInfo tea where teaName=?1";

		TeacherInfo teacherInfo = teaInfoDao.queryTeacherInfo(hql4, session, topicTeacher);
		System.out.println(teacherInfo);

		int selectd_number = teacherInfo.getSelectedNumber();
		System.out.println("原选课人数：" + selectd_number);
		selectd_number++;
		teacherInfo.setSelectedNumber(selectd_number);
		teaInfoDao.updateTeacherInfo(session, teacherInfo);

		topicInfos.setIsSelectd(0);
		topicInfoDao.updateTopicInfo(session, topicInfos);

		tx.commit(); //提交事务
		String hql_all = "select new TopicInfo(t.topicId,t.topicTea,t.topicName,t.number,t.topicType,t.isSelectd) from TopicInfo as t order by topicTea asc";
		List<TopicInfo> topicInfo_all = topic.queryAllTopic(hql_all, session);
		String hql2 = "from StudentInfo stuInfo where stuNo = ?1";
		StudentInfo studentInfo = topic.querySelectedTopic(hql2, session, stuNo);//查询改学生的选题情况
		if (studentInfo != null) {	//不为空，就代表已经选过题了
			request.setAttribute("n", 1);//标记改学生有没有选题，以便于在index.jsp方便判断
			request.setAttribute("selectedTopic", studentInfo);
		} else {
			request.setAttribute("n", 0);//标记改学生有没有选题，以便于在index.jsp方便判断
			request.setAttribute("selectedTopic", null);
		}
		request.setAttribute("user", students.getUserName());
		request.setAttribute("topic", topicInfo_all);

		Page page = new PageImpl();
		page.pageCount(session, request, topic);
		HibernateUtil.closeSession(session);
		return "index/index_selected.jsp";
	}

	/**
	 * 查询课题
	 */
	@RequestMapping("/search")
	public void searchTopic(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Session session = HibernateUtil.getSession();
		List<TopicInfo> topicInfos = null;
		String search = request.getParameter("search").trim();
		System.out.println(search);
		String hql_teaName = "select teaInfo.teaName from TeacherInfo as teaInfo";
		List<String> names = teaInfoDao.queryAllTeacherName(hql_teaName, session); // 查询所有老师的名字
		if (search != null && search.length() >= 2 && search.length() <= 3 && names.contains(search)) { // 如果输入的字符包含老师的名字，则根据老师的名字查询课题
			String hql = "from TopicInfo where topicTea like ?1";
			topicInfos = topic.querySearchResultByTopicTea(hql, session, search);
		} else if (search != null && topicInfos == null) {
			String hql = "from TopicInfo where topicName like ?2";
			topicInfos = topic.querySearchResultByTopicName(hql, session, search);
		}
		JSONArray jsonArray = JSONArray.fromObject(topicInfos);// 将List转为json，以便ajax的遍历
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(jsonArray);
		HibernateUtil.closeSession(session);
	}

	/**
	 * 分页操作
	 */
	@RequestMapping("/index")
	public String page(HttpServletRequest request) {
		Session session = HibernateUtil.getSession();
		Page page = new PageImpl();
		page.pageCount(session, request, topic);
		HibernateUtil.closeSession(session);
		return "index_all.jsp?page" + page;
	}
	
	/*
	 * 导航栏操作
	 */
	@RequestMapping("/index_all")
	public String topicAll(HttpServletRequest request){
		new PageImpl().pageCount(HibernateUtil.getSession(), request, topic);
		return "index/index_all.jsp";
	}
	
	@RequestMapping("/index_network")
	public String topicNetwork(HttpServletRequest request){
		new PageImpl().pageCount(HibernateUtil.getSession(), request, topic);
		return "index/index_network.jsp";
	}
	
	@RequestMapping("/index_communication")
	public String topicCommunication(HttpServletRequest request){
		new PageImpl().pageCount(HibernateUtil.getSession(), request, topic);
		return "index/index_communication.jsp";
	}
	
	@RequestMapping("/index_selected")
	public String topicSelected(HttpServletRequest request){
		new PageImpl().pageCount(HibernateUtil.getSession(), request, topic);
		return "index/index_selected.jsp";
	}
	
	@RequestMapping("/index_search")
	public String topicSearch(HttpServletRequest request){
		new PageImpl().pageCount(HibernateUtil.getSession(), request, topic);
		return "index/index_search.jsp";
	}
}
