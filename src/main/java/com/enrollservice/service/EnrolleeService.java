package com.enrollservice.service;

import java.util.List;

import com.enrollservice.models.DependentEnrollee;
import com.enrollservice.models.Enrollee;

public interface EnrolleeService {

	boolean createEnrollee(Enrollee enrollee);

	List<Enrollee> getEnrollees();

	boolean modifyEnrollee(Enrollee enrollee);

	boolean removeEnrollee(long id);

	boolean addDependent(long enrollee_ID, DependentEnrollee dependentEnrollee);

	boolean removeDependent(long enrollee_ID, long dependent_ID);

}
