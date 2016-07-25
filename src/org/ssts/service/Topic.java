package org.ssts.service;

import java.util.List;

import org.hibernate.Session;
import org.ssts.entity.StudentInfo;
import org.ssts.entity.TopicInfo;

public interface Topic {

	/**
	 * 查询15条记录
	 * @param hql
	 * @param session
	 * @param page
	 * @return
	 */
	public abstract List<TopicInfo> queryTopic(String hql, Session session, int page);

	/**
	 * 根据课程ID查询课程
	 * @param session
	 * @param topicId
	 * @return
	 */
	public abstract TopicInfo querySingleTopicById(Session session, int topicId);

	/**
	 * 查询已选课题
	 * @param hql
	 * @param session
	 * @param stuNo
	 * @return
	 */
	public abstract StudentInfo querySelectedTopic(String hql, Session session, String stuNo);

	/**
	 * 查询所选课题老师的QQ
	 * @param hql
	 * @param session
	 * @param teaName
	 * @return
	 */
	public abstract String querySelectedTeacherQQ(String hql, Session session, String teaName);

	/**
	 * 根据老师名字查询课题
	 * @param hql
	 * @param session
	 * @param topicTea
	 * @return 结果集
	 */
	public abstract List<TopicInfo> querySearchResultByTopicTea(String hql, Session session, String topicTea);

	/**
	 * 根据课题名字查询课题
	 * @param hql
	 * @param session
	 * @param topicName
	 * @return
	 */
	public abstract List<TopicInfo> querySearchResultByTopicName(String hql, Session session, String topicName);
	
	/**
	 * 查询课题数量
	 * @param hql
	 * @param session
	 * @return
	 */
	public abstract int queryTopicCount(String hql, Session session);
	
	/**
	 * 查询所有课题
	 * @param hql
	 * @param session
	 * @return
	 */
	public abstract List<TopicInfo> queryAllTopic(String hql, Session session);
	
	/**
	 * 根据课题类别查询课题
	 * @param hql
	 * @param session
	 * @param type
	 * @param page
	 * @return
	 */
	public abstract List<TopicInfo> queryTopicType(String hql, Session session, String type, int page);
	
	/**
	 * 根据课题类别查询课题的数量
	 * @param hql
	 * @param session
	 * @param type
	 * @return
	 */
	public abstract int queryTopicNumberType(String hql, Session session,String type);
}
