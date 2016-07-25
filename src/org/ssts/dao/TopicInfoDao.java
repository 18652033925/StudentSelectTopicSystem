package org.ssts.dao;

import org.hibernate.Session;
import org.ssts.entity.TopicInfo;

public interface TopicInfoDao {
	
	public abstract void updateTopicInfo(Session session, TopicInfo topicInfo);

}
