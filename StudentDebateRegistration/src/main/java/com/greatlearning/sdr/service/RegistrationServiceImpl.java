package com.greatlearning.sdr.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.sdr.model.Student;



@Repository
public class RegistrationServiceImpl implements RegistrationService{
	
	
private SessionFactory sessionFactory;
private Session session;

@Autowired
public RegistrationServiceImpl(SessionFactory sessionFactory) {
	
			this.sessionFactory = sessionFactory;
	try {
		this.session = sessionFactory.getCurrentSession();
	}catch(HibernateException he) {
		this.session = sessionFactory.openSession();
	}
}

@Transactional
public List<Student>viewAllStudents() {
	@SuppressWarnings("unchecked")
	List<Student> list = (List<Student>)session.createQuery("from student_registration").list();
	return list;
}


@Transactional
public void save(Student student) {
	Transaction tx = session.beginTransaction();
	session.saveOrUpdate(student);
	tx.commit();
}


@Transactional
public Student delete(int id) {
	Student student = session.get(Student.class, id);
	session.delete(student);
	return student;
}

@Transactional
public Student getStudentById(int id) {
	return session.get(Student.class, id);
}

}