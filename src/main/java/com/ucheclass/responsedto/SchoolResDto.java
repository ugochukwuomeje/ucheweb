package com.ucheclass.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolResDto {

    private String responseMessage;
    private int responseCode;

    private List<String> errors;
}
