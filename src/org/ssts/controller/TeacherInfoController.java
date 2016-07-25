package org.ssts.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssts.dao.TeacherInfoDao;
import org.ssts.dao.impl.TeacherInfoDaoImpl;
import org.ssts.entity.TeacherInfo;
import org.ssts.util.HibernateUtil;

import net.sf.json.JSONArray;

@Controller
public class TeacherInfoController {

	@RequestMapping("/lookTeacherInfo")
	public void lookTeacherInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Session session = HibernateUtil.getSession();
		String teaName = request.getParameter("teaName");
		String hql = "from TeacherInfo where teaName = ?1";
		TeacherInfoDao teacherInfoDao = new TeacherInfoDaoImpl();
		TeacherInfo teacherInfo = teacherInfoDao.queryTeacherInfo(hql, session, teaName);//根据老师姓名查询老师信息
		JSONArray json = JSONArray.fromObject(teacherInfo);	//把List转为JSON格式数据
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json);
		HibernateUtil.closeSession(session);
	}
}
