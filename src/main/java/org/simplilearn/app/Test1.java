package org.simplilearn.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.simplilearn.app.config.HbConfig;
import org.simplilearn.app.entities.Passport;
import org.simplilearn.app.entities.Student;

public class Test1 {

	public static void main(String[] args) {

		SessionFactory factory=HbConfig.getSessionFactory();
		Session session=factory.openSession();
		Passport passport=session.get(Passport.class,1);
		Student st=passport.getStudent();
		System.out.println(st.getName()+"\t"+st.getAddress());
		
	}

}
