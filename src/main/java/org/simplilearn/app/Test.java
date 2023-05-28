package org.simplilearn.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.app.config.HbConfig;
import org.simplilearn.app.entities.Passport;
import org.simplilearn.app.entities.Student;

public class Test {

	public static void main(String[] args) {

		SessionFactory factory=HbConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			Passport passport=new Passport();
			passport.setPassportNumber("GHAVXHJ53131321gh");
	        passport.setIssuedDate(new Date(2022,11,20));
			Student st=new Student();
			st.setName("Preeti");
			st.setAddress("Haryana");
            st.setPid(passport);		
          //session.save(passport);
            session.save(st);
            tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		/*
		 * Student st=session.get(Student.class,1); Passport passport=st.getPid();
		 * System.out.println(st.getName()+"\t"+st.getAddress());
		 * System.out.println(passport.getPassportNumber()+"\t"+passport.getIssuedDate()
		 * );
		 */
		 
		
	}

}
