package com.ucheclass.controller;

import com.google.gson.Gson;
import com.ucheclass.entity.Faculty;
import com.ucheclass.entity.School;
import com.ucheclass.repository.SchoolRepo;
import com.ucheclass.requestdto.*;
import com.ucheclass.responsedto.*;
import com.ucheclass.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1")
public class Controller {

    Logger logger;


    public Controller(){

        logger = Logger.getLogger(Controller.class.getName());
    }

    @Autowired
    private UsersService usersService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SchoolRepo schoolRepo;

    @PostMapping("/user")
    public UserResDto createUser(@RequestBody UserReqDto userReqDto, @Valid BindingResult result){
        Gson gson = new Gson();
        logger.info(":::::::::::::::::::::::the request sent for creating new user: "+gson.toJson(userReqDto));

        if(result.hasErrors()){
            UserResDto userResDto = new UserResDto();

            result.getAllErrors().forEach( error->{
                List<String> listErrors = new ArrayList<String>();
                listErrors.add(error.getDefaultMessage());
                userResDto.setErrors(listErrors);

                int a = 1;
                int b = + +a;

                logger.info("::::::::::::::::::the error in creating user is: "+gson.toJson(userReqDto));
            });

            return userResDto;
        }

        return usersService.saveUsers(userReqDto);

    }

    @PostMapping("/course")
    public CourseResDto createCourse(@Valid  @RequestBody CourseReqDto courseReqDto, BindingResult result ){

        Gson gson = new Gson();
        logger.info("::::::::::::::::::::::::::::::::the request sent for creating course is: "+gson.toJson(courseReqDto));
       return courseService.createCourse(courseReqDto);

    }

    @PostMapping("/faculty")
    public FacultyResDto createfaculty(@Valid @RequestBody ListFacultyReqDto facultyReqDto){

        Gson gson = new Gson();
        logger.info("::::::::::::::::::::::::::::::::calling faculty service method: "+gson.toJson(facultyReqDto));

        return facultyService.createFaculty(facultyReqDto);
    }

    @GetMapping("/faculty")
    public FacultyResDto getAllFaculty(){

        logger.info(":::::::::::::::::::::::::get all faculties");

        return facultyService.findAllFaculties();
    }

    @GetMapping("/faculty/{id}")
    public FacultyResDto getfacultyById(@PathVariable BigInteger id){

        logger.info("::::::::::::::::::::::::::::::::::::get faculty by Id: "+id);

        return facultyService.findFacultyBySchoolId(id);
    }

    @PostMapping("/department")
    public DepartmentResDto createDepartment(@RequestBody DepartmentReqDto departmentReqDto){

        Gson gson = new Gson();
        logger.info("::::::::::::::::::::::::::creating department record with the request: "+gson.toJson(departmentReqDto));

        return departmentService.createDepartment(departmentReqDto);

    }

    @PostMapping("/school")
    public SchoolResDto createSchool(@RequestBody SchoolReqDto schoolResDto){

        Gson gson = new Gson();
        logger.info(":::::::::::::::::::::::create a new school with the request: "+gson.toJson(schoolResDto));

        return schoolService.createNewSchool(schoolResDto);
    }

    @GetMapping("/school")
    public List<School> getAllSchool(){

        logger.info("::::::::::::::::::::::::::::::: get all schools");

        return  schoolService.getAllSchool();
    }

}
