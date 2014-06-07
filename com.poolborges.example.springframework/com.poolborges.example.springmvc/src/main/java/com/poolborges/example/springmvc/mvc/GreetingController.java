package com.poolborges.example.springmvc.mvc;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    //protected static Logger logger = Logger.getLogger("GreetingController");

    //define the same url with GET so users can skip to the greetings page
    //note there is no actual greetings.html file!! 
    @RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
    public String showAllGreetings(@RequestParam(value = "greetingText", required = true) String greetingText,
            Map<String, Object> model) {

        //logger.info("entering showAllGreetings");

        model.put("greetingText", greetingText);

        // This will resolve to /WEB-INF/views/greeting/greetings.jsp
        return "greeting/greeting-home";
    }

    @RequestMapping(value = "/greeting-add.html", method = RequestMethod.GET)
    public String showAddGreetingPage() {

        //logger.info("entering showAddGreetingPage");

        // This will resolve to /WEB-INF/views/greeting/greeting-add.jsp
        return "greeting/greeting-add";
    }
}
