package com.ucheclass.responsedto;


import com.ucheclass.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResDto {

    private List<Department> departmentList;

    private Integer resCode;
    private String resMessage;
}
