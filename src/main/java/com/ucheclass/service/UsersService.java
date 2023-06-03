package com.ucheclass.service;

import com.ucheclass.entity.Users;
import com.ucheclass.requestdto.UserReqDto;
import com.ucheclass.responsedto.UserResDto;
import org.springframework.stereotype.Service;


public interface UsersService {

    public UserResDto saveUsers(UserReqDto userReqDto);

    public Users findUserByEmail(String email);
}
