package org.ssts.service.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ssts.dao.StudentInfoDao;
import org.ssts.dao.impl.StudentInfoDaoImpl;
import org.ssts.entity.Student;
import org.ssts.service.User;
import org.ssts.util.HibernateUtil;


public class UserImpl implements User {

	@Override
	public String changePassword(String oldPassword, String newPassword, String stuNo) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		StudentInfoDao stuInfo = new StudentInfoDaoImpl();
		String hql = "from Student as stu where stu.userNo = ?1";
		Student stu = stuInfo.queryStudentByStuNo(hql, session, stuNo);
		if (stu.getPassword().equals(oldPassword)) {
			stu.setPassword(newPassword);
			session.update(stu);
			tx.commit();
		} else {
			HibernateUtil.closeSession(session);
			return "原始密码输入不正确，请重新输入";
		}
		HibernateUtil.closeSession(session);
		return "密码修改完成，请重新登录";
	}

	@Override
	public Student queryStudentInfo(String stuNo) {
		Session session = HibernateUtil.getSession();
		StudentInfoDao stuInfo = new StudentInfoDaoImpl();
		String hql = "from Student as stu where stu.userNo = ?1";
		Student stu = stuInfo.queryStudentByStuNo(hql, session, stuNo);
		HibernateUtil.closeSession(session);
		return stu;
	}

}
