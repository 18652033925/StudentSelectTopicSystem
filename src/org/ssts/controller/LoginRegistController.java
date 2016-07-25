package org.ssts.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssts.dao.StudentInfoDao;
import org.ssts.dao.impl.StudentInfoDaoImpl;
import org.ssts.entity.Student;
import org.ssts.service.Page;
import org.ssts.service.Topic;
import org.ssts.service.impl.PageImpl;
import org.ssts.service.impl.TopicImpl;
import org.ssts.util.HibernateUtil;

/**
 * 登录注册控制器，用于实现用户的注册，登录等操作
 * 
 * @author 方曦
 *
 */
@Controller
public class LoginRegistController {

	private Transaction tx;
	private Session session;
	private StudentInfoDao loginRegistDao = new StudentInfoDaoImpl();
	private Topic topic;

	@RequestMapping("/regist")
	public String regist(Student stu) {
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		stu.setRegistTime(new Date());
		loginRegistDao.addStuRegist(stu, session);
		tx.commit();
		HibernateUtil.closeSession(session);
		System.out.println(stu);
		return "login.jsp";
	}

	@RequestMapping("/login")
	public String login(Student stu, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String stuNo = request.getParameter("userNo");
		String password = request.getParameter("password");
		session = HibernateUtil.getSession();
		topic = new TopicImpl();
		String hql = "select new Student(stu.id,stu.userNo,stu.password,stu.userName) from Student as stu where stu.userNo=?1";
		boolean flag = false;
		Student student = loginRegistDao.queryStudentByStuNo(hql, session, stuNo);
		if (student != null) {
			if (stuNo.equals(student.getUserNo()) && password.equals(student.getPassword())) {
				request.setAttribute("user", student.getUserName());
				HibernateUtil.USERNAME = student.getUserName();
				HibernateUtil.USERNO = student.getUserNo();
				HibernateUtil.UERID = student.getId();
				flag = true;
			} else {
				flag = false;
			}
		}

		if (flag) {
			Page page = new PageImpl();
			page.pageCount(session, request, topic);
			HibernateUtil.closeSession(session);
			return "index/index_all.jsp";
		} else {
			String error = "<div style='color:black;'><h4>错误!</h4>" + "<strong>错误!</strong> 用户名或密码输入错误</div>";
			request.setAttribute("errorInfo", error);
			HibernateUtil.closeSession(session);
			return "login.jsp";
		}
		
	}
}
