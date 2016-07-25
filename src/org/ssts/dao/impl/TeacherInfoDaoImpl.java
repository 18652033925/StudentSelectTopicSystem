package org.ssts.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ssts.dao.TeacherInfoDao;
import org.ssts.entity.TeacherInfo;

public class TeacherInfoDaoImpl implements TeacherInfoDao {

	@Override
	public void updateTeacherInfo(Session session, TeacherInfo teaInfo)  {
		session.update(teaInfo);
	}

	@Override
	public TeacherInfo queryTeacherInfo(String hql, Session session, String teaName) {
		Query query = session.createQuery(hql);
		query.setParameter("1", teaName);
		TeacherInfo teacherInfo = (TeacherInfo) query.uniqueResult();
		return teacherInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryAllTeacherName(String hql, Session session) {
		List<String> names = session.createQuery(hql).list();
		return names;
	}

}
