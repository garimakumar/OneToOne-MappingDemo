package org.simplilearn.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.app.config.HbConfig;
import org.simplilearn.app.entities.Role;
import org.simplilearn.app.entities.User;

public class Test3 {

	public static void main(String[] args) {
        SessionFactory factory=HbConfig.getSessionFactory();
		Session session=factory.openSession();
	    Transaction tx=session.beginTransaction();
	try {
		User u1=new User();
		u1.setUsername("Garima");
		u1.setPassword("Garima@1991");
		User u2=new User();
		u2.setUsername("Ginni");
		u2.setPassword("Ginni@1991");
        Role r1=new Role();
        r1.setRolename("ADMIN");
        Role r2=new Role();
        r2.setRolename("MANAGER");
        u1.addRole(r1);
        u1.addRole(r2);
        r1.addUser(u1);
        r2.addUser(u1);
        u2.addRole(r1);
        r1.addUser(u2);
        session.save(r1);
        session.save(r2);
        session.save(u1);
        session.save(u2);
        tx.commit();
	} catch (Exception e) {
	    tx.rollback();	
	}
	    session.close();
	}

}
