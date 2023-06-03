package com.ucheclass.responsedto;

import com.ucheclass.entity.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllSchoolsResDto {

    private List<School> schools;
    private long total;

}
