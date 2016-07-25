package org.ssts.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.ssts.entity.StudentInfo;
import org.ssts.entity.TopicInfo;
import org.ssts.service.Page;
import org.ssts.service.Topic;
import org.ssts.util.HibernateUtil;

public class PageImpl implements Page {

	private static final String COMMUNICATION = "现代通信技术";
	private static final String NETWORK = "计算机网络技术";

	@Override
	public void pageCount(Session session, HttpServletRequest request, Topic topic) {
		String pageString = request.getParameter("page");
		int page;
		if (pageString != null) {
			page = Integer.parseInt(pageString);
		} else {
			page = 1;
		}
		// 查询所有课题
		String hql1 = "from TopicInfo as t order by topicTea asc";
		// 查询课题数量
		String hql_count = "select count(*) from TopicInfo";
		int num = topic.queryTopicCount(hql_count, session); // 查询共有多少条记录
		String hql_count_type = "select count(*) from TopicInfo as t where t.topicType = ?1";
		int num_communication = topic.queryTopicNumberType(hql_count_type, session, COMMUNICATION);
		int num_network = topic.queryTopicNumberType(hql_count_type, session, NETWORK);
		request.setAttribute("num", num);
		request.setAttribute("num_communication", num_communication);
		request.setAttribute("num_network", num_network);
		request.setAttribute("user", HibernateUtil.USERNAME);
		request.setAttribute("page", page);// 传递页码给前台
		List<TopicInfo> topicInfos = topic.queryTopic(hql1, session, page);
		request.setAttribute("topic", topicInfos);
		String hql_type = "from TopicInfo as t where t.topicType = ?1 order by topicTea asc";
		String hql_all = "from TopicInfo";
		List<TopicInfo> topicInfos_all = topic.queryAllTopic(hql_all, session);
		List<TopicInfo> topicInfos_communication = topic.queryTopicType(hql_type, session, COMMUNICATION, page);// 查询现代通信技术的课题
		List<TopicInfo> topicInfos_network = topic.queryTopicType(hql_type, session, NETWORK, page);// 查询计算机网络技术的课题
		request.setAttribute("topicAll", topicInfos_all);
		request.setAttribute("communication", topicInfos_communication);
		request.setAttribute("network", topicInfos_network);
		// 查询该登录的学生所选课题信息
		String hql2 = "from StudentInfo stuInfo where stuNo = ?1";
		String stuNo = HibernateUtil.USERNO;
		StudentInfo studentInfo = topic.querySelectedTopic(hql2, session, stuNo);
		if (studentInfo != null) { // 如过该学生选择了课题，保存选择的课题信息。否则为null
			request.setAttribute("selectedTopic", studentInfo);
		} else {
			request.setAttribute("selectedTopic", null);
		}
	}

}
