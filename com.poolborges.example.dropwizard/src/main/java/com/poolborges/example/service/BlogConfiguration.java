package com.poolborges.example.service;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
 
public class BlogConfiguration extends Configuration{
 
    @Min(1)
    @Max(65535)
    @JsonProperty
    private final int port = 5672;
    
    //@NotEmpty
    @JsonProperty
    private String host;
    
    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
