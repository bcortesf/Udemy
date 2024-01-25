package com.company.springboot3web.domain.entitys.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.springboot3web.domain.entitys.User;

@Component
public class UserTest2DTO {

    private User user;

    public UserTest2DTO(@Autowired User user){
        this.user = user;
    }


    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
        this.user.setPassword(this.user.getPassword().concat("***"));
    }
}
