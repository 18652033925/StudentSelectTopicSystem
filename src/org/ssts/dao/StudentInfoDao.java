package org.ssts.dao;

import java.util.List;

import org.hibernate.Session;
import org.ssts.entity.Student;
import org.ssts.entity.StudentInfo;

public interface StudentInfoDao {

	public abstract void addStuRegist(Student stu, Session session);

	public abstract void addStuInfo(StudentInfo stuInfo, Session session);

	public abstract List<Student> queryStudent(String hql, Session session);

	public abstract Student queryStudentById(String hql, Session session, int stuId);

	public abstract String querySelectedTeacher(Session session, int stuId);

	public abstract Student queryStudentByStuNo(String hql, Session session, String stuNo);
}
