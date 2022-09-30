package com.greatlearning.sdr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.sdr.model.Student;

public interface RegistrationService {
	
	public List<Student> viewAllStudents();
	public void save(Student student);
	public Student delete(int id);
	public Student getStudentById(int id);

}

