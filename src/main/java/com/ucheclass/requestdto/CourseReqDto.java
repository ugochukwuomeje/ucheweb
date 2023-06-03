package com.ucheclass.requestdto;

import com.ucheclass.entity.School;
import com.ucheclass.entity.Users;
import com.ucheclass.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseReqDto {
    @NotNull(message="course code cannot be empty")
    private String courseCode;
   @NotNull(message = "Course cannot be empty")
    private String courseTitle;
   @NotNull(message = "School cannot be empty")
    private BigInteger schoolId;
    @Enumerated(EnumType.STRING)
    private Level level;
  @NotNull(message = "Course cannot be empty")
    private BigInteger usersId;
}
