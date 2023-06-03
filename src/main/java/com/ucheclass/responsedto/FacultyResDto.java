package com.ucheclass.responsedto;

import com.ucheclass.entity.Faculty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyResDto {

    private String responseMessage;
    private int responseCode;

    private List<Faculty> faculties;

    private Faculty faculty;

}
