package com.hibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentInfoMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address address = new Address("OMR Road", "Chennai", "TN", "600097");
		
		StudentInfo student1 = new StudentInfo("Eswar", address);
		StudentInfo student2 = new StudentInfo("Joe", address);
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void main(String[] args) {
		StudentInfoMain student = new StudentInfoMain();
		student.insert();
	}

}
