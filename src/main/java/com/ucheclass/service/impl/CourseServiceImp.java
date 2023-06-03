package com.ucheclass.service.impl;

import com.ucheclass.entity.Course;
import com.ucheclass.entity.School;
import com.ucheclass.entity.Users;
import com.ucheclass.enums.CourseStatus;
import com.ucheclass.enums.ErrorCodeMessage;
import com.ucheclass.repository.CourseRepo;
import com.ucheclass.repository.SchoolRepo;
import com.ucheclass.repository.UserRepo;
import com.ucheclass.requestdto.CourseReqDto;
import com.ucheclass.responsedto.CourseResDto;
import com.ucheclass.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CourseServiceImp implements CourseService {

    private Logger logger;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private SchoolRepo schoolRepo;
    @Autowired
    private UserRepo userRepo;
    public CourseServiceImp(){

        logger = Logger.getLogger(CourseServiceImp.class.getName());
    }
    @Override
    public CourseResDto createCourse(CourseReqDto courseReqDto) {

        Course course = new Course();
        CourseResDto courseResDto;

        logger.info(":::::::::::::::fetching school information");

        Optional<School> optionalSchool = schoolRepo.findById(courseReqDto.getSchoolId());

        if(!optionalSchool.isPresent()){

            courseResDto = new CourseResDto();
            courseResDto.setResCode("2");
            courseResDto.setResponseMsg(ErrorCodeMessage.getError(2));

            return courseResDto;
        }

        Optional<Users> optionalUsers = userRepo.findById(courseReqDto.getUsersId());

        if(!optionalUsers.isPresent()){
            courseResDto = new CourseResDto();
            courseResDto.setResCode("2");
            courseResDto.setResponseMsg(ErrorCodeMessage.getError(2));

            return courseResDto;
        }

        School school = optionalSchool.get();
        Users users = optionalUsers.get();

        course.setCourseCode(courseReqDto.getCourseCode());
        course.setCourseTitle(courseReqDto.getCourseTitle());
        course.setStatus(CourseStatus.DISABLED);
        course.setLevel(courseReqDto.getLevel());
        course.setSchoolId(school);
        course.setUsers(users);

        try{
            courseRepo.saveAndFlush(course);

        } catch (Exception e){

            return getCourseRes("3", ErrorCodeMessage.getError(3));

        }

        return getCourseRes("0", ErrorCodeMessage.getError(0));
    }

    public CourseResDto getCourseRes(String code, String msg){

        CourseResDto courseResDto = new CourseResDto();

        courseResDto.setResponseMsg(msg);
        courseResDto.setResCode(code);

        return courseResDto;
    }
}
