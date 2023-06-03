package com.ucheclass.requestdto;

import com.ucheclass.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentReqDto {

    private List<Department> departmentList;


}
