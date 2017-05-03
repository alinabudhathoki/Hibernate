package com.hibernate.onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmployeeInfoMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();

		EmployeeInfo employee = new EmployeeInfo("Alina", 25000);

		Phone home = new Phone("0143000", "Home");
		Phone office = new Phone("0145622", "Office");

		List<Phone> phone = employee.getPhone();
		phone.add(home);
		phone.add(office);

		employee.setPhone(phone);

		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public void select() {
		Session session = sf.openSession();
		session.beginTransaction();

		String queryString = "from EmployeeInfo";
		Query query = session.createQuery(queryString);
		List<EmployeeInfo> result = query.list();
		for (EmployeeInfo c : result) {
			System.out.println(c.toString());
		}
	}

	public static void main(String[] args) {
		EmployeeInfoMain employee = new EmployeeInfoMain();
		employee.insert();
		employee.select();
	}
}
