package org.ssts.service;

import org.ssts.entity.Student;

public interface User {

	/*
	 * 修改密码
	 */
	public abstract String changePassword(String oldPassword, String newPassword, String stuNo);
	
	/**
	 * 查询学生信息
	 */
	public abstract Student queryStudentInfo(String stuNo);
}
