package com.ucheclass.enums;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ErrorCodeMessage {

    static Map<Integer, String>errorMsg = new HashMap<Integer, String>();

    public ErrorCodeMessage(){
        errorMsg.put(-1, "Not created");
        errorMsg.put(0, "Successful");
        errorMsg.put(201, "Created");
        errorMsg.put(2, "error fetching record");
        errorMsg.put(3,"Record not found");
        errorMsg.put(4, "email already exist");
        errorMsg.put(5, "school does not exist");
        errorMsg.put(6, "user does not exist");
        errorMsg.put(7,"School not found");
    }

    public static String getError(int errorCode){

        return errorMsg.get(errorCode);
    }
}
