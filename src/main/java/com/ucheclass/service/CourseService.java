package com.ucheclass.service;

import com.ucheclass.requestdto.CourseReqDto;
import com.ucheclass.responsedto.CourseResDto;

public interface CourseService {

    public CourseResDto createCourse(CourseReqDto courseReqDto);
}
