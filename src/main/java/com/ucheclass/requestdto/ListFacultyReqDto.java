package com.ucheclass.requestdto;

import com.ucheclass.entity.Faculty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFacultyReqDto {

    private List<Faculty> facultyList;
}
