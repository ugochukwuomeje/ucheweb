package com.ucheclass.service.impl;

import com.ucheclass.entity.Department;
import com.ucheclass.enums.ErrorCodeMessage;
import com.ucheclass.repository.DepartmentRepo;
import com.ucheclass.repository.FacultyRepo;
import com.ucheclass.repository.SchoolRepo;
import com.ucheclass.requestdto.DepartmentReqDto;
import com.ucheclass.responsedto.DepartmentResDto;
import com.ucheclass.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private Logger logger;
  public DepartmentServiceImpl(){
    logger = Logger.getLogger(DepartmentServiceImpl.class.getName());
  }
  @Autowired
  private DepartmentRepo departmentRepo;

  @Autowired
  private FacultyRepo facultyRepo;

  @Autowired
  private SchoolRepo schoolRepo;
  @Override
  public DepartmentResDto createDepartment(DepartmentReqDto departmentReqDto){

    logger.info(("::::::::::::::::::::calling create department in departmentserviceimpl"));
    DepartmentResDto departmentResDto = null;

    logger.info("::::::::::::::::::::::::::::check if school exist");
    Department department = departmentReqDto.getDepartmentList().get(0);
    if(!schoolRepo.existsById(department.getSchool())){

      logger.info("::::::::::::::::::::::::::::::::::::::::::school does not exist");
      departmentResDto = new DepartmentResDto();
      departmentResDto.setResMessage(ErrorCodeMessage.getError(5));
      departmentResDto.setResCode(5);

      return departmentResDto;
    }

    if(facultyRepo.existsById(departmentReqDto.getDepartmentList().get(0).getFaculty())){
      logger.info(":::::::::::::::::::::::::::::::::::faculty does not exist");
      departmentResDto = new DepartmentResDto();
      departmentResDto.setResMessage(ErrorCodeMessage.getError(5));
      departmentResDto.setResCode(5);

      return departmentResDto;
    }

    try {
      List<Department> listDepartment = departmentReqDto.getDepartmentList();
      departmentRepo.saveAll(listDepartment);
      departmentResDto = new DepartmentResDto();

      departmentResDto.setResCode(201);
      departmentResDto.setResMessage(ErrorCodeMessage.getError(201));

    }catch (Exception e){

      departmentResDto = new DepartmentResDto();

      departmentResDto.setResCode(201);
      departmentResDto.setResMessage(ErrorCodeMessage.getError(201));
    }

    return departmentResDto;
  }

  @Override
  public DepartmentResDto getAllDepartment() {

    logger.info(":::::::::::::::::::::::::::calling get all department");
    DepartmentResDto departmentResDto =  new DepartmentResDto();
      try {
        departmentResDto.setDepartmentList(departmentRepo.findAll());
        departmentResDto.setResCode(0);
        departmentResDto.setResMessage(ErrorCodeMessage.getError(0));
      }catch (Exception e){
        departmentResDto.setResCode(2);
        departmentResDto.setResMessage(ErrorCodeMessage.getError(2));
      }
    return departmentResDto;
  }

  @Override
  public DepartmentResDto getDepartmentByFacultyAndSchool(BigInteger school, BigInteger faculty) {

    logger.info(":::::::::::::::calling get department by school and faculty service");
    DepartmentResDto departmentResDto = new DepartmentResDto();

    Optional<List<Department>> optListDepartment = departmentRepo.findBySchoolAndfaculty(school, faculty);

    if(optListDepartment.isEmpty()){

      departmentResDto.setResMessage(ErrorCodeMessage.getError(3));
      departmentResDto.setResCode(3);

    }
    departmentResDto.setDepartmentList(optListDepartment.get());
    departmentResDto.setResCode(0);
    departmentResDto.setResMessage(ErrorCodeMessage.getError(0));
    return departmentResDto;
  }


}
