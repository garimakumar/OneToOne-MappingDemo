package org.simplilearn.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.app.config.HbConfig;
import org.simplilearn.app.entities.Course;
import org.simplilearn.app.entities.Student;

public class Test2 {

	public static void main(String[] args) {

		SessionFactory factory=HbConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			Student st=session.get(Student.class,2);
			Course c1=new Course();
			c1.setCourseName("Java");
			c1.setFee(5000);
			Course c2=new Course();
			c2.setCourseName("SQL");
			c2.setFee(2500);
			Course c3=new Course();
			c3.setCourseName("Python");
			c3.setFee(1500);
			c1.setStudent(st);
			c2.setStudent(st);
			c3.setStudent(st);
			session.save(st);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
		}
		finally {
			session.close();
		}
	}

}
