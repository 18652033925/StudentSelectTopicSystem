package org.ssts.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentInfo {

	@Id
	private int stuId;
	private String stuNo;
	private String stuName;
	private String stuGrade;
	private String stuTel;
	@Column(name = "stu_qq")
	private String stuQQ;
	private String stuType;
	private String selectedTopic;
	private String selectedTeacher;
	private Date selectedTime;

	public StudentInfo() {
	}

	public StudentInfo(int stuId, String stuNo, String stuName, String stuGrade, String stuTel, String stuQQ,
			String stuType, String selectedTopic, String selectedTeacher, Date selectedTime) {
		this.stuId = stuId;
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuGrade = stuGrade;
		this.stuTel = stuTel;
		this.stuQQ = stuQQ;
		this.stuType = stuType;
		this.selectedTopic = selectedTopic;
		this.selectedTeacher = selectedTeacher;
		this.selectedTime = selectedTime;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuGrade() {
		return stuGrade;
	}

	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}

	public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getStuQQ() {
		return stuQQ;
	}

	public void setStuQQ(String stuQQ) {
		this.stuQQ = stuQQ;
	}

	public String getStuType() {
		return stuType;
	}

	public void setStuType(String stuType) {
		this.stuType = stuType;
	}

	public String getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(String selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	public String getSelectedTeacher() {
		return selectedTeacher;
	}

	public void setSelectedTeacher(String selectedTeacher) {
		this.selectedTeacher = selectedTeacher;
	}

	public Date getSelectedTime() {
		return selectedTime;
	}

	public void setSelectedTime(Date selectedTime) {
		this.selectedTime = selectedTime;
	}

	@Override
	public String toString() {
		return "StudentInfo [stuId=" + stuId + ", stuNo=" + stuNo + ", stuName=" + stuName + ", stuGrade=" + stuGrade
				+ ", stuTel=" + stuTel + ", stuQQ=" + stuQQ + ", stuType=" + stuType + ", selectedTopic="
				+ selectedTopic + ", selectedTeacher=" + selectedTeacher + ", selectedTime=" + selectedTime + "]";
	}

}
