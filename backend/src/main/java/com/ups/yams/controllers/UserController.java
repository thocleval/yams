package com.ups.yams.controllers;

import com.ups.yams.model.UserDataObject;
import com.ups.yams.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    UserMongoRepository userMongoRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody void addUser(@ModelAttribute UserDataObject user) {
        userMongoRepository.save(user);
    }

}
