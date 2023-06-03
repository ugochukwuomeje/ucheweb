package com.ucheclass.service;

import com.ucheclass.entity.School;
import com.ucheclass.requestdto.SchoolReqDto;
import com.ucheclass.responsedto.SchoolResDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SchoolService {

    public SchoolResDto createNewSchool(SchoolReqDto schoolReqDto);

    public List<School> getAllSchool();

}
