package com.ucheclass.requestdto;

import com.ucheclass.enums.SchoolCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolReqDto {

    private  String name;
    private SchoolCategory schoolCategory;
}
