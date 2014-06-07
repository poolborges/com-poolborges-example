package com.poolborges.example.springjpa.employee;

/**
 *
 * @author Borges
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainCreateTable {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("DataTable.xml");

        CreateTable myBean = (CreateTable) ctx.getBean("CreateTable");
        myBean.doExecute();
        myBean.doInsert();

    }
}