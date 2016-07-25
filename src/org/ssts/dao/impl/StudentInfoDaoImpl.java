package org.ssts.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ssts.dao.StudentInfoDao;
import org.ssts.entity.Student;
import org.ssts.entity.StudentInfo;
import org.ssts.entity.TeacherInfo;

public class StudentInfoDaoImpl implements StudentInfoDao {

	@Override
	public void addStuRegist(Student stu, Session session) {
		session.save(stu);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> queryStudent(String hql, Session session) {
		List<Student> students = session.createQuery(hql).list();
		return students;
	}

	@Override
	public Student queryStudentById(String hql, Session session, int stuId) {
		Student student = (Student) session.get(Student.class, stuId);
		return student;
	}

	@Override
	public void addStuInfo(StudentInfo stuInfo, Session session) {
		session.save(stuInfo);
	}

	@Override
	public String querySelectedTeacher(Session session, int stuId) {
		TeacherInfo teacherInfo = (TeacherInfo) session.get(TeacherInfo.class, stuId);
		return teacherInfo.getTeaName();

	}

	@Override
	public Student queryStudentByStuNo(String hql, Session session, String stuNo) {
		Query query = session.createQuery(hql);
		query.setParameter("1", stuNo);
		Student student = (Student) query.uniqueResult();
		return student;
	}

}
