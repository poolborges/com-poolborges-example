package com.poolborges.example;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
 
public class BlogConfiguration extends Configuration{
 
    @Min(1)
    @Max(65535)
    @JsonProperty
    private int port = 5672;
}
