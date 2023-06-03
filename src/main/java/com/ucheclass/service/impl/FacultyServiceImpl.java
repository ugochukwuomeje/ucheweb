package com.ucheclass.service.impl;

import com.ucheclass.entity.Faculty;
import com.ucheclass.entity.School;
import com.ucheclass.enums.ErrorCodeMessage;
import com.ucheclass.repository.FacultyRepo;
import com.ucheclass.repository.SchoolRepo;
import com.ucheclass.requestdto.ListFacultyReqDto;
import com.ucheclass.responsedto.FacultyResDto;
import com.ucheclass.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FacultyServiceImpl implements FacultyService {

    private Logger logger;

    public FacultyServiceImpl(){

        logger = Logger.getLogger(FacultyServiceImpl.class.getName());
    }

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private ErrorCodeMessage errorCodeMessage;

    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public FacultyResDto createFaculty(ListFacultyReqDto listFacultyReqDto){

        FacultyResDto facultyResDto = new FacultyResDto();

        logger.info(":::::::::::::::::::::::::check if school exist");

        Optional<School> school = schoolRepo.findById(listFacultyReqDto.getFacultyList().get(0).getSchoolId());

        if(school.isPresent()){

            facultyResDto.setResponseCode(7);
            facultyResDto.setResponseMessage(ErrorCodeMessage.getError(7));

            return facultyResDto;
        }

        try{
            logger.info("::::::::::::::::::::creating faculty");
            List<Faculty> listFaculty = listFacultyReqDto.getFacultyList();
            facultyRepo.saveAll(listFaculty);

        }catch(Exception e){
            logger.info(":::::::::::::::::::::::::could not create faculty");
            facultyResDto.setResponseMessage(ErrorCodeMessage.getError(-1));
            facultyResDto.setResponseCode(-1);

            return facultyResDto;
        }
        logger.info(":::::::::::::::::::::::::::::::::creating faculty");
        facultyResDto.setResponseCode(201);
        facultyResDto.setResponseMessage(ErrorCodeMessage.getError(201));

        return facultyResDto;

    }

    @Override
    public FacultyResDto findAllFaculties() {

        FacultyResDto facultyResDto = new FacultyResDto();

        try{
            facultyResDto.setFaculties(facultyRepo.findAll());
            facultyResDto.setResponseCode(0);
            facultyResDto.setResponseMessage(ErrorCodeMessage.getError(0));
        }catch (Exception e){

            facultyResDto.setResponseCode(2);
            facultyResDto.setResponseMessage(ErrorCodeMessage.getError(2));
        }
        return facultyResDto;
    }

    @Override
    public FacultyResDto findFacultyBySchoolId(BigInteger schoolId) {

        logger.info(":::::::::::::::::::::::::::::::::::getting faculties by school Id");
        FacultyResDto facultyResDto = new FacultyResDto();
        Optional<List<Faculty>> faculty = null;

        try{

            faculty = facultyRepo.findBySchoolId(schoolId);

            if(faculty.isEmpty()){

                facultyResDto.setResponseCode(5);
                facultyResDto.setResponseMessage(ErrorCodeMessage.getError(5));

                return facultyResDto;

            }

            facultyResDto.setFaculties(faculty.get());
            facultyResDto.setResponseCode(0);
            facultyResDto.setResponseMessage(ErrorCodeMessage.getError(0));
        }catch (Exception e){
            e.printStackTrace();

            facultyResDto.setResponseCode(2);
            facultyResDto.setResponseMessage(ErrorCodeMessage.getError(2));
        }
        return facultyResDto;
    }
}
