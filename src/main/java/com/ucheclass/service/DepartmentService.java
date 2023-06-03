package com.ucheclass.service;

import com.ucheclass.requestdto.DepartmentReqDto;
import com.ucheclass.responsedto.DepartmentResDto;

import java.math.BigInteger;

public interface DepartmentService {

    public DepartmentResDto createDepartment(DepartmentReqDto departmentReqDto);

    public DepartmentResDto getAllDepartment();

    public DepartmentResDto getDepartmentByFacultyAndSchool(BigInteger school, BigInteger faculty);

}
