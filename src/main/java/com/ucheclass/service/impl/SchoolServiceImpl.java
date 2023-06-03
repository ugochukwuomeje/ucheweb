package com.ucheclass.service.impl;

import com.google.gson.Gson;
import com.ucheclass.entity.School;
import com.ucheclass.enums.ErrorCodeMessage;
import com.ucheclass.repository.SchoolRepo;
import com.ucheclass.requestdto.SchoolReqDto;
import com.ucheclass.responsedto.AllSchoolsResDto;
import com.ucheclass.responsedto.SchoolResDto;
import com.ucheclass.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SchoolServiceImpl implements SchoolService {

    Logger logger;
    public SchoolServiceImpl(){
        logger = Logger.getLogger(SchoolServiceImpl.class.getName());

    }

    @Autowired
    private School school;

    @Autowired
    private SchoolRepo schoolRepo;

    public SchoolResDto createNewSchool(SchoolReqDto schoolReqDto){

        Gson gson = new Gson();
        SchoolResDto schoolResDto = null;
        logger.info(":::::::::::::::::::::::::calling school service class: "+gson.toJson(schoolReqDto));

        school.setSchoolCategory(schoolReqDto.getSchoolCategory());
        school.setName(schoolReqDto.getName());

        try{
            schoolRepo.save(school);
        }catch (Exception e){

            logger.info(":::::::::::::::::the error in creatingnew school is: "+e.getMessage());
            e.printStackTrace();
            schoolResDto = new SchoolResDto();
            schoolResDto.setResponseCode(-1);
            schoolResDto.setResponseMessage(ErrorCodeMessage.getError(-1));
            return schoolResDto;

        }

        schoolResDto = new SchoolResDto();
        schoolResDto.setResponseCode(201);
        schoolResDto.setResponseMessage(ErrorCodeMessage.getError(201));
        return schoolResDto;

    }
    public List<School> getAllSchool(){

        return schoolRepo.findAll();
    }

    private AllSchoolsResDto getSchool(String name){

       Optional<List<School>> optSchool =  schoolRepo.findAllByName(name);
        AllSchoolsResDto allSchoolsResDto = new AllSchoolsResDto();

       if(optSchool.isEmpty()){
           allSchoolsResDto.setTotal(0);
           return allSchoolsResDto;
       }

        allSchoolsResDto.setSchools(optSchool.get());
        allSchoolsResDto.setTotal(allSchoolsResDto.getSchools().size());

        return allSchoolsResDto;
    }
}
