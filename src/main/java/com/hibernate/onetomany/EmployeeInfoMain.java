package com.hibernate.onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

	public static void main(String[] args) {
		EmployeeInfoMain employee = new EmployeeInfoMain();
		employee.insert();

	}
}
