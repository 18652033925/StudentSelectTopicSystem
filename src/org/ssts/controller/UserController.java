package org.ssts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssts.entity.Student;
import org.ssts.service.User;
import org.ssts.service.impl.PageImpl;
import org.ssts.service.impl.TopicImpl;
import org.ssts.service.impl.UserImpl;
import org.ssts.util.HibernateUtil;

@Controller
public class UserController {
	
	private User user = new UserImpl();
	
	@RequestMapping("/changePassword")
	public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String stuNo = request.getParameter("stuNo");
		String msg = null;
		if (newPassword1.equals(newPassword2)) {
			msg = user.changePassword(oldPassword, newPassword2, stuNo);
			response.getWriter().print(msg);
		} else {
			response.getWriter().print("两次密码输入不一致");
		}
	}

	@RequestMapping("/index_user")
	public String index_user(HttpServletRequest request){
		Student stu = user.queryStudentInfo(HibernateUtil.USERNO);
		new PageImpl().pageCount(HibernateUtil.getSession(), request, new TopicImpl());
		request.setAttribute("stu", stu);
		return "index/index_user.jsp";
	}
}
