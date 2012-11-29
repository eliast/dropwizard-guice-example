package com.example.helloworld.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.helloworld.core.Saying;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.yammer.metrics.annotation.Timed;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
	
	final Logger logger = LoggerFactory.getLogger(HelloWorldResource.class);
	
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    @Inject
    public HelloWorldResource(@Named("template") String template, @Named("defaultName") String defaultName) {
    	logger.info("Creating a new HelloWorldResource!");
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        return new Saying(counter.incrementAndGet(),
                          String.format(template, name.or(defaultName)));
    }
    
    @PreDestroy
    void destroy() {
    	logger.info("Destroying HelloWorldResource... :(");
    }
}