package com.enrollservice;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enrollservice.models.DependentEnrollee;
import com.enrollservice.models.Enrollee;
import com.enrollservice.repositories.DependentRepository;
import com.enrollservice.repositories.EnrolleeRepository;
import com.enrollservice.service.DependentService;
import com.enrollservice.service.EnrolleeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrolleeApplicationTests {
	
	 @Autowired
	    private EnrolleeService enrolleeService;
	    @Autowired
	    private EnrolleeRepository enrolleeRepository;
	    @Autowired
	    private DependentService dependentService;
	    @Autowired
	    private DependentRepository dependentRepository;

	    @Test
	    public void createEnrollee() {
	        Enrollee enrollee = new Enrollee(1, "Mark", true, "11/01/1990", "566-255-44-33");
	        Assert.assertTrue(enrolleeService.createEnrollee(enrollee));
	        Optional<Enrollee> result = enrolleeRepository.findById((long) 1);
	        Assert.assertEquals(enrollee.getId(), result.get().getId());
	        Assert.assertEquals(enrollee.getName(), result.get().getName());
	        Assert.assertEquals(enrollee.getPhone_Number(), result.get().getPhone_Number());
	        Assert.assertEquals(enrollee.getBirth_Day(), result.get().getBirth_Day());
	    }

	    @Test
	    public void modifyEnrollee() {
	        Enrollee enrollee = new Enrollee(1, "John", true, "11/01/1995", "566-255-44-33");
	        enrolleeService.createEnrollee(enrollee);
	        Enrollee enrollee2 = new Enrollee(1, "Sham", false,"11/01/1905", "566-255-44-33");
	        Assert.assertTrue(enrolleeService.modifyEnrollee(enrollee2));
	        Optional<Enrollee> result = enrolleeRepository.findById((long) 1);
	        Assert.assertEquals(enrollee2.getId(), result.get().getId());
	        Assert.assertEquals(enrollee2.getName(), result.get().getName());
	        Assert.assertEquals(enrollee2.getPhone_Number(), result.get().getPhone_Number());
	        Assert.assertEquals(enrollee2.getBirth_Day(), result.get().getBirth_Day());
	    }

	    @Test
	    public void removeEnrollee()
	    {
	        Enrollee enrollee = new Enrollee(1, "John", true, "11/01/1995", "566-255-44-33");
	        enrolleeService.createEnrollee(enrollee);
	        Assert.assertTrue(enrolleeService.removeEnrollee(1));
	    }

	    @Test
	    public void addDependent()
	    {
	        Enrollee enrollee = new Enrollee(1, "Tina", true, "11/01/1901", "566-255-44-33");
	        enrolleeService.createEnrollee(enrollee);
	        DependentEnrollee dependentEnrollee = new DependentEnrollee(2, "Tim", "12/08/1999");
	        Assert.assertFalse(enrolleeService.addDependent(1,dependentEnrollee));
	    }

	    @Test
	    public void removeDependent()
	    {
	        Enrollee enrollee = new Enrollee(1, "Tina", true, "11/01/1901", "566-255-44-33");
	        enrolleeService.createEnrollee(enrollee);
	        DependentEnrollee dependentEnrollee = new DependentEnrollee(2, "Tim", "12/08/1999");
	        enrolleeService.addDependent(1,dependentEnrollee);
	        Assert.assertFalse(enrolleeService.removeDependent(1,2));
	    }

	    @Test
	    public void modifyDependent()
	    {
	        Enrollee enrollee = new Enrollee(1, "Mark", true, "11/01/1901", "566-255-44-33");
	        enrolleeService.createEnrollee(enrollee);
	        DependentEnrollee dependentEnrollee = new DependentEnrollee(2, "Chrish", "12/08/1999");
	        enrolleeService.addDependent(1,dependentEnrollee);
	        DependentEnrollee dependentEnrollee2 = new DependentEnrollee(2, "Kid", "13/08/1999");
	        Assert.assertFalse(dependentService.modifyDependentEnrollee(dependentEnrollee2));
	    }

		public DependentRepository getDependentRepository() {
			return dependentRepository;
		}

		public void setDependentRepository(DependentRepository dependentRepository) {
			this.dependentRepository = dependentRepository;
		}

}
