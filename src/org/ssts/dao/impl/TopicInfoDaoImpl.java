package org.ssts.dao.impl;

import org.hibernate.Session;
import org.ssts.dao.TopicInfoDao;
import org.ssts.entity.TopicInfo;

public class TopicInfoDaoImpl implements TopicInfoDao {

	@Override
	public void updateTopicInfo(Session session, TopicInfo topicInfo) {
		session.update(topicInfo);
	}

}
