package com.hibernate.onetoone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class StudentMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();

		Student student = new Student();
		student.setName("Alina");

		Department dept = new Department();
		dept.setName("CSIT");

		student.setDepartment(dept);

		session.save(student);
		session.close();
	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public void select() {
		Session session = sf.openSession();
		session.beginTransaction();

		String queryString = "from Student";
		Query query = session.createQuery(queryString);
		List<Student> result = query.list();
		for (Student c : result) {
			System.out.println(c.toString());
		}
	}

	public static void main(String[] args) {
		StudentMain student = new StudentMain();
		student.insert();
		student.select();

	}
}
