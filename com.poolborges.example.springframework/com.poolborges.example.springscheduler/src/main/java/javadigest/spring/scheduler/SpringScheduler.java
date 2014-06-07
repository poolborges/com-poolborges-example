package javadigest.spring.scheduler;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScheduler {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("context.xml");
    }
}
