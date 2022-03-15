package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(BigDecimal id){
        userService.delete(id);
    }
}
