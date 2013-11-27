package com.xabe.tutorial.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.xabe.tutorial.ws.rest.RestWs;

@ApplicationPath("/ws")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(RestWs.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        final Set<Object> instances = new HashSet<Object>();
        instances.add(new JacksonFeature());
        return instances;
    }
}