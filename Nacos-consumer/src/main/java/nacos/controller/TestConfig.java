package nacos.controller;

import nacos.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :     ring2
 * @date :       2020/3/28 09:54
 * description:
 **/
@RestController
public class TestConfig {
    @Autowired
    User user;
    @GetMapping("/people")
    public String getUser(){
        return user.getName() + user.getAge();
    }
}
