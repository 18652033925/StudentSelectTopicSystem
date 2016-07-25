package org.ssts.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ssts.entity.StudentInfo;
import org.ssts.entity.TeacherInfo;
import org.ssts.entity.TopicInfo;
import org.ssts.service.Topic;

public class TopicImpl implements Topic {

	private static final int NUMBER = 20;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TopicInfo> queryTopic(String hql, Session session, int page) {
		Query query = session.createQuery(hql);
		query.setFirstResult((page - 1) * NUMBER);
		query.setMaxResults(NUMBER);
		List<TopicInfo> topicInfos = query.list();
		return topicInfos;
	}

	@Override
	public TopicInfo querySingleTopicById(Session session, int topicId) {
		TopicInfo topicInfo = (TopicInfo) session.get(TopicInfo.class, topicId);
		return topicInfo;

	}

	@Override
	public StudentInfo querySelectedTopic(String hql, Session session, String stuNo) {
		Query query = session.createQuery(hql);
		query.setParameter("1", stuNo);
		StudentInfo studentInfo = (StudentInfo) query.uniqueResult();
		return studentInfo;
	}

	@Override
	public String querySelectedTeacherQQ(String hql, Session session, String teaName) {
		Query query = session.createQuery(hql);
		query.setParameter("1", teaName);
		TeacherInfo teacherInfo = (TeacherInfo) query.uniqueResult();
		return teacherInfo.getTeaQQ();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopicInfo> querySearchResultByTopicTea(String hql, Session session, String topicTea) {
		Query query = session.createQuery(hql);
		query.setParameter("1", "%" + topicTea + "%");
		List<TopicInfo> topicInfos = query.list();
		return topicInfos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopicInfo> querySearchResultByTopicName(String hql, Session session, String topicName) {
		Query query = session.createQuery(hql);
		query.setParameter("2", "%" + topicName + "%");
		List<TopicInfo> topicInfos = query.list();
		return topicInfos;
	}

	@Override
	public int queryTopicCount(String hql, Session session) {
		Query query = session.createQuery(hql);
		int count = ((Long) query.iterate().next()).intValue();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopicInfo> queryAllTopic(String hql, Session session) {
		List<TopicInfo> topicInfos = (List<TopicInfo>) session.createQuery(hql).list();
		return topicInfos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopicInfo> queryTopicType(String hql, Session session, String type, int page) {
		Query query = session.createQuery(hql);
		query.setParameter("1", type);
		query.setFirstResult((page - 1) * NUMBER);
		query.setMaxResults(NUMBER);
		List<TopicInfo> topicInfos_type = query.list();
		return topicInfos_type;
	}

	@Override
	public int queryTopicNumberType(String hql, Session session, String type) {
		Query query = session.createQuery(hql);
		query.setParameter("1", type);
		int count = ((Long) query.iterate().next()).intValue();
		return count;
	}

}
