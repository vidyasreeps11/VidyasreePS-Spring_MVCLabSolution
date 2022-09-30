package com.greatlearning.sdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.sdr.model.Student;
import com.greatlearning.sdr.service.RegistrationService;

@Controller
@RequestMapping("/student")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping("/")
	public String homePage(Model model)
	{
		return "Home";
	}

	@RequestMapping("/add")
	public String addNewStudent(Model model)
	{
		Student student=new Student();
		model.addAttribute("student",student);
		return "RegistrationConfirmationPage";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("reg_id") int reg_id, @RequestParam("firstname") String firstname,
						@RequestParam("lastname") String lastname,@RequestParam("department") String department,
						@RequestParam("emailaddress") String emailaddress,@RequestParam("phoneno") String phoneNo) {
		Student student;
		if(reg_id != 0) {
			student = registrationService.getStudentById(reg_id);
		}else {
			student = new Student();
		}
		student.setFirstName(firstname);
		student.setLastName(lastname);
		student.setDepartment(department);
		student.setEmailAddress(emailaddress);
		student.setPhoneNo(phoneNo);
		
		return "RegisteredStudentList";
	}
	
	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> result = registrationService.viewAllStudents();
		model.addAttribute("Students", result);
		return "RegisteredStudentList";
	}
	
	
	@RequestMapping("/update")
	public String updateStudent(@RequestParam("id") int id,Model model) {
		Student student = registrationService.getStudentById(id);
		model.addAttribute("student", student);
		return "Home";
	}
	
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("reg_id") int id) {
		Student student = registrationService.delete(id);
		System.out.println("Deleted Student Id"+ student.getReg_id());
		return "Home";
	}
}
