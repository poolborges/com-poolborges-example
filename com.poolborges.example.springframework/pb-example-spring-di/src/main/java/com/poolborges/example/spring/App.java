package com.poolborges.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-config.xml");
        Topico topic1 = (Topico)appContext.getBean("topicoDia1");
        Topico topic2 = (Topico)appContext.getBean("topicoDia2");
        Topico topic3 = (Topico)appContext.getBean("topicoDia3");
        System.out.println("\n"+ topic1 +"\n"+ topic2 +"\n"+ topic3);
    }
}
