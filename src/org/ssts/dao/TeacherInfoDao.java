package org.ssts.dao;


import java.util.List;

import org.hibernate.Session;
import org.ssts.entity.TeacherInfo;

public interface TeacherInfoDao {

	//更新老师信息
	public abstract void updateTeacherInfo(Session session, TeacherInfo teaInfo);
	
	//根据老师姓名查询老师信息
	public abstract TeacherInfo queryTeacherInfo(String hql, Session session, String teaName);
	
	//查询全部老师的姓名
	public abstract List<String> queryAllTeacherName(String hql, Session session);

}
