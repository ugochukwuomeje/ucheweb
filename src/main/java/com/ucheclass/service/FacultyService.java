package com.ucheclass.service;

import com.ucheclass.entity.Faculty;
import com.ucheclass.repository.FacultyRepo;
import com.ucheclass.requestdto.ListFacultyReqDto;
import com.ucheclass.responsedto.FacultyResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


public interface FacultyService {


    public FacultyResDto createFaculty(ListFacultyReqDto listFacultyReqDto);

    public FacultyResDto findAllFaculties();

    public FacultyResDto findFacultyBySchoolId(BigInteger schoolId);

}
