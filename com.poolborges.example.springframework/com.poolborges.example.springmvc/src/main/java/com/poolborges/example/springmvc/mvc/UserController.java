package com.poolborges.example.springmvc.mvc;

import com.poolborges.example.springmvc.domain.User;
import com.poolborges.example.springmvc.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("say-hello")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public @ModelAttribute("message")
    String getInitialMessage() {
        return "Enter a Valid Name";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ModelAttribute("message")
    String getGreeting(@RequestParam("username") String username) {
        User user = userDao.getForUsername(username);
        return "Hello, " + user.getFirstName() + " " + user.getLastName() + "!";
    }
}