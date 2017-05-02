package com.hibernate.elementcollection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setName("Alina");
		
		Address temporary = new Address();
		temporary.setCity("Dang");
		temporary.setStreet("Tulsipur");
		

		 Address permanent = new Address();
		permanent.setCity("Kathmandu");
		permanent.setStreet("Gongabu");
		
		List<Address> address = employee.getAddress();
		
		address.add(temporary);
		address.add(permanent);
		employee.setAddress(address);
		
		session.save(employee);
		session.getTransaction().commit();
		session.close();		
	}
	
	public static void main(String[] args) {
		EmployeeMain employee = new EmployeeMain();
		employee.insert();
	}
}
