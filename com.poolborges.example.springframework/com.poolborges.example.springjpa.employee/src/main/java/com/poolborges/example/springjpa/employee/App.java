package com.poolborges.example.springjpa.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        // Create a new application context. this processes the Spring config
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-DB.xml");
        // Retrieve the data source from the application context
        DataSource ds = (DataSource) ctx.getBean("dataSource");
        // Open a database connection using Spring's DataSourceUtils
        Connection c = DataSourceUtils.getConnection(ds);
        try {
            // retrieve a list of three random cities
            PreparedStatement ps = c.prepareStatement(
                    "SELECT City.Name as 'City', Country.Name as 'Country' "
                    + "FROM City INNER JOIN Country on City.CountryCode = Country.Code "
                    + "ORDER by rand() limit 3");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String city = rs.getString("City");
                String country = rs.getString("Country");
                System.out.printf("The city %s is in %s%n", city, country);
            }
        } catch (SQLException ex) {
            // something has failed and we print a stack trace to analyse the error
            ex.printStackTrace();
            // ignore failure closing connection
            try {
                c.close();
            } catch (SQLException e) {
            }
        } finally {
            // properly release our connection
            DataSourceUtils.releaseConnection(c, ds);
        }
    }
}
