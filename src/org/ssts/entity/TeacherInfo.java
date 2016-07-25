package org.ssts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_info")
public class TeacherInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teaId;
	private String teaName;
	@Column(name="tea_qq")
	private String teaQQ;
	private String team;
	private String officeLocation;
	private int selectedNumber;
	private int isSelected;
	private String teaType;

	public TeacherInfo() {
	}

	public TeacherInfo(int teaId, String teaName, String teaQQ, String team, String officeLocation, int selectedNumber,
			int isSelected, String teaType) {
		this.teaId = teaId;
		this.teaName = teaName;
		this.teaQQ = teaQQ;
		this.team = team;
		this.officeLocation = officeLocation;
		this.selectedNumber = selectedNumber;
		this.isSelected = isSelected;
		this.teaType = teaType;
	}

	public int getTeaId() {
		return teaId;
	}

	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaQQ() {
		return teaQQ;
	}

	public void setTeaQQ(String teaQQ) {
		this.teaQQ = teaQQ;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public int getSelectedNumber() {
		return selectedNumber;
	}

	public void setSelectedNumber(int selectedNumber) {
		this.selectedNumber = selectedNumber;
	}

	public int getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}

	public String getTeaType() {
		return teaType;
	}

	public void setTeaType(String teaType) {
		this.teaType = teaType;
	}

	@Override
	public String toString() {
		return "TeacherInfo [teaId=" + teaId + ", teaName=" + teaName + ", teaQQ=" + teaQQ + ", team=" + team
				+ ", officeLocation=" + officeLocation + ", selectedNumber=" + selectedNumber + ", isSelected="
				+ isSelected + ", teaType=" + teaType + "]";
	}

}
