package org.ssts.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_stu")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userNo;
	private String userName;
	private String password;
	private Date registTime;
	private String stuType;

	public Student() {

	}

	public Student(String userNo, int id, String userName, String stuType) {
		this.userNo = userNo;
		this.id = id;
		this.userName = userName;
		this.stuType = stuType;
	}

	public Student(int id, String userNo, String password, String userName) {
		this.id = id;
		this.userNo = userNo;
		this.password = password;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public String getStuType() {
		return stuType;
	}

	public void setStuType(String stuType) {
		this.stuType = stuType;
	}

	@Override
	public String toString() {
		return "学生注册信息为： [学号=" + userNo + ", 姓名=" + userName + ", 密码=" + password + ", 注册时间=" + registTime + ", 学生类别="
				+ stuType + "]";
	}

}
