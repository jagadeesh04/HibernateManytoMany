package com.jag.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test {

	public static void main(String[] args) {
		
		StudentCertification studentCertification1 = new StudentCertification();
		studentCertification1.setCertification_name("java");
		
		StudentCertification studentCertification2 = new StudentCertification();
		studentCertification2.setCertification_name("database");
		
		Student student1 = new Student();
		student1.setStudent_name("jag");
		(student1.getStudentCertification()).add(studentCertification1);
	
		Student student2 = new Student();
		student2.setStudent_name("jag");
		(student2.getStudentCertification()).add(studentCertification2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
		
	}
	
}
