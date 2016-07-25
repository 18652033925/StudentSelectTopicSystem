package org.ssts.util;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {

	private static ApplicationContext ctx;
	private static SessionFactory sessionFactory;
	public static String USERNAME = null;
	public static String USERNO = null;
	public static int UERID = 0;

	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = ctx.getBean(SessionFactory.class);
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static void closeSession(Session session) throws HibernateException {
		if (session != null) {
			session.close();
		}
	}

	public static DataSource getDataSource() throws HibernateException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		return dataSource;
	}
}
