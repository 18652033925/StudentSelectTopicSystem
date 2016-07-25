package org.ssts.service;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

public interface Page {
	
	public abstract void pageCount(Session session, HttpServletRequest request, Topic topic);

}
