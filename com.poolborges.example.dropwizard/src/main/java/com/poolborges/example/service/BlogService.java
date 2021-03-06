package com.poolborges.example.service;

import com.poolborges.example.resource.BlogResource;
import com.poolborges.example.resource.IndexResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class BlogService extends Service<BlogConfiguration> {

    @Override
    public void initialize(Bootstrap<BlogConfiguration> bootstrap) {
        bootstrap.setName("Blog Service");
    }

    @Override
    public void run(BlogConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new IndexResource());
        environment.addResource(new BlogResource());

    }

}
