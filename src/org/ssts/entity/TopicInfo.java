package org.ssts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic_info")
public class TopicInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;
	private String topicTea;
	private String topicName;
	private int number;
	private String topicType;
	private int isSelectd;

	public TopicInfo() {
	}

	public TopicInfo(String topicTea, String topicName,int isSelected) {
		this.topicTea = topicTea;
		this.topicName = topicName;
		this.isSelectd = isSelected;
	}

	public TopicInfo(int topicId, String topicTea, String topicName, int number, String topicType, int isSelectd) {
		this.topicId = topicId;
		this.topicTea = topicTea;
		this.topicName = topicName;
		this.number = number;
		this.topicType = topicType;
		this.isSelectd = isSelectd;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicTea() {
		return topicTea;
	}

	public void setTopicTea(String topicTea) {
		this.topicTea = topicTea;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}

	public int getIsSelectd() {
		return isSelectd;
	}

	public void setIsSelectd(int isSelectd) {
		this.isSelectd = isSelectd;
	}

}
