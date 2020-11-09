package com.enrollservice.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrollservice.models.DependentEnrollee;
import com.enrollservice.service.DependentService;

@RestController
@RequestMapping("/v2")
public class DependentRestController {

	@Autowired
	private DependentService dependentService;

	public void DependentEnrollee(DependentEnrollee dependentEnrollee, DependentService dependentService) {
		this.dependentService = dependentService;
	}

	@PutMapping("/api/dependent/modify")
	public boolean modifyEnrollee(long id, String name, String birth_Day) {
		try {
			DependentEnrollee dependentEnrollee = new DependentEnrollee(id, name, birth_Day);
			dependentService.modifyDependentEnrollee(dependentEnrollee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/api/dependent/get")
	public List<DependentEnrollee> getDependents() {
		return dependentService.getDependents();
	}
}
