package com.poolborges.example.springmvc.controller;

import com.poolborges.example.springmvc.dto.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller("/contact")
@SessionAttributes
public class ContactController {

    @RequestMapping(value = "/contactAdd", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {

        System.out.println("First Name:" + contact.getFirstname()
                + "Last Name:" + contact.getLastname());

        return "redirect:contact/contactList.html";
        //return new ModelAndView("contactAdd.jsp");
    }

    @RequestMapping("/contactList")
    public ModelAndView showContacts() {

        return new ModelAndView("contact", "command", new Contact());
    }
}
