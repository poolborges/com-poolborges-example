package com.poolborges.example.log4j;

import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Borges
 */
public class Log4Example {

    private static String loj4jFileName = "log4j.properties ";//change the property file name here
    private static Logger LOG = Logger.getLogger(Log4Example.class);//change here

    public Log4Example() {
        try {
            InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(loj4jFileName);
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load logging property for Class... ");
        }
        LOG.info("Log4j Property File for Class Loaded Properly..");
    }

    public String getValues(String param) {
        try {
        } catch (Exception e) {
            LOG.debug("Exception: " + e.getMessage());
            LOG.error(e);
        }
        LOG.info("Method Execution is successfull...");
        return param;
    }
}
