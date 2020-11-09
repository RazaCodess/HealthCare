package com.enrollservice.service;

import java.util.List;

import com.enrollservice.models.DependentEnrollee;

public interface DependentService {

	boolean modifyDependentEnrollee(DependentEnrollee dependentEnrollee);

	List<DependentEnrollee> getDependents();

}
