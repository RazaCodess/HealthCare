package com.enrollservice.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrollservice.models.DependentEnrollee;
import com.enrollservice.models.Enrollee;
import com.enrollservice.service.EnrolleeService;

@RestController
@RequestMapping("/v1")
public class EnrolleeRestController {
	@Autowired
	private EnrolleeService enrolleeService;

	public void EnrolleeService(EnrolleeService enrolleeService)
	{
		this.enrolleeService = enrolleeService;
	}

	@PostMapping("/api/enrollee/create")
	public void saveEnrollee(@RequestBody long id, String name, boolean activation_Status, String birth_Day, String phone_Number)
	{
		Enrollee enrollee = new Enrollee(id, name, activation_Status, birth_Day, phone_Number);
		enrolleeService.createEnrollee(enrollee);
	}

	@GetMapping("/api/enrollee/get")
	public List<Enrollee> getEnrollees()
	{
		return enrolleeService.getEnrollees();
	}

	@PutMapping("/api/enrollee/modify")
	public void modifyEnrollee(long id, String name, boolean activation_Status, String birth_Day, String phone_Number)
	{
		Enrollee enrollee = new Enrollee(id, name, activation_Status, birth_Day, phone_Number);
		enrolleeService.modifyEnrollee(enrollee);
	}

	@DeleteMapping("/api/enrollee/remove")
	public void removeEnrollee(long id)
	{
		enrolleeService.removeEnrollee(id);
	}

	@PostMapping("/api/enrollee/dependent/add")
	public void addDependent(long enrollee_ID, DependentEnrollee dependentEnrollee)
	{
		enrolleeService.addDependent(enrollee_ID, dependentEnrollee);
	}

	@DeleteMapping("/api/enrollee/dependent/remove")
	public void removeDependent(long enrollee_ID, long dependent_ID)
	{
		enrolleeService.removeDependent(enrollee_ID, dependent_ID);
	}
}


