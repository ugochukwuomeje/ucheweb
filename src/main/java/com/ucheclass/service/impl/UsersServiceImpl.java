package com.ucheclass.service.impl;

import com.google.gson.Gson;
import com.ucheclass.entity.Users;
import com.ucheclass.enums.ErrorCodeMessage;
import com.ucheclass.repository.UserRepo;
import com.ucheclass.requestdto.UserReqDto;
import com.ucheclass.responsedto.UserResDto;
import com.ucheclass.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ErrorCodeMessage errorCodeMessage;

    private Logger logger;

    Gson gson = null;

    public UsersServiceImpl(){

        logger = Logger.getLogger(UsersServiceImpl.class.getName());
        gson = new Gson();
    }
    @Override
    public UserResDto saveUsers(UserReqDto userReqDto) {

        Users users = null;
        UserResDto userResDto = new UserResDto();

        logger.info("::::::::::::::::::::the request sent for user creation is: "+gson.toJson(userReqDto));

        logger.info("::::::::::::::::::::::::::::::check if user exist");
        users = findUserByEmail(userReqDto.getEmail());

        if(users != null){

            userResDto.setResponseCode(4);
            userResDto.setResponseMessage(errorCodeMessage.getError(4));

            logger.info("::::::::::::::::::::::::::user exist"+gson.toJson(userResDto));

            return userResDto;
        }

        users = createNewUserObjec(userReqDto);

        try{
            userRepo.save(users);
            userResDto.setResponseMessage(errorCodeMessage.getError(201));
            userResDto.setResponseCode(201);
        }catch (
                Exception e){

            logger.info(":::::::::::::::::::::::the error in saving user to db is: "+e.getMessage());
            userResDto.setResponseMessage(errorCodeMessage.getError(-1));
            userResDto.setResponseCode(-1);

        }

        return userResDto;
    }

    public Users createNewUserObjec(UserReqDto userReqDto){

        Users users = new Users();

        users.setUserPosition(userReqDto.getUserPosition());
        users.setCountry(userReqDto.getCountry());
        users.setFirstName(userReqDto.getFirstName());
        users.setPassword(userReqDto.getPassword());
        users.setPhoneNumber(userReqDto.getPhone());
        users.setSchool(userReqDto.getSchool());
        users.setEmail(userReqDto.getEmail());
        users.setLastName(userReqDto.getLastName());

        return users;
    }

    public Users findUserByEmail(String email){

        logger.info(":::::::::::::::::::::::::find user with the email: "+email);

        Optional<Users> optUsers = userRepo.findUserByEmail(email);

        if(optUsers.isEmpty()){

            return null;
        }

        Users users = optUsers.get();

        return users;
    }


}
