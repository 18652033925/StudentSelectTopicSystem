package org.ssts.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssts.entity.StudentInfo;
import org.ssts.service.Topic;
import org.ssts.service.impl.TopicImpl;
import org.ssts.util.HibernateUtil;

/**
 * 用于发送邮件通知选课老师的控制器
 * 
 * @author 方曦
 *
 */
@Controller
public class JavaMail {

	@RequestMapping("/tellTeacher")
	public void tellTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		org.hibernate.Session session = HibernateUtil.getSession();
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");

		Topic topic = new TopicImpl();
		String hql = "from StudentInfo stuInfo where stuNo = ?1";
		StudentInfo stuInfo = topic.querySelectedTopic(hql, session, stuNo);
		String teacherName = stuInfo.getSelectedTeacher();
		String hql2 = "from TeacherInfo teaInfo where teaName = ?1";
		String teacherQQ = topic.querySelectedTeacherQQ(hql2, session, teacherName);

		String teacherQQMail = teacherQQ + "@qq.com";

		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ccit_fx", "qq512618664");
			}
		};

		Session sessionMail = Session.getInstance(props, auth);

		MimeMessage msg = new MimeMessage(sessionMail);
		msg.setFrom(new InternetAddress("ccit_fx@163.com"));// 设置发件人
		msg.setRecipients(RecipientType.TO, teacherQQMail);// 设置收件人

		String message = "亲爱的" + teacherName + "老师，" + stuName + "同学在" + stuInfo.getSelectedTime() + ",选择了您的《"
				+ stuInfo.getSelectedTopic() + "》课题。该学生的手机号码为：" + stuInfo.getStuTel() + "，QQ号为：" + stuInfo.getStuQQ();
		msg.setSubject("课题被选通知");// 设置邮件主题
		msg.setContent(message, "text/html;charset=utf-8"); // 设置邮件内容以及编码方式

		Transport.send(msg);// 发送邮件
		response.setCharacterEncoding("utf-8");
		response.getWriter().println("已成功发送邮件给指导老师!");
	}
}
