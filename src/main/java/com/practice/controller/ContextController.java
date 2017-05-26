package com.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ravikiran_gorthi on 5/11/17.
 */
@RestController
public class ContextController {

    @RequestMapping("/")
    @ResponseBody
    public String sayWelcome() {
        return "Welcome : You have successfully built a Restful Webservices App" +
                "<br><br>" +
                "<a href='./users'>See Users</a>";
    }
}
