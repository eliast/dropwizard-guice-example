package com.example.helloworld;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class HelloWorldService extends Service<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloWorldService().run(args);
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		bootstrap.setName("hello-world");
		
		GuiceBundle<HelloWorldConfiguration> guiceBundle = GuiceBundle.<HelloWorldConfiguration>newBuilder()
				.addModule(new HelloWorldModule())
				.enableAutoConfig(getClass().getPackage().getName())
				.setConfigClass(HelloWorldConfiguration.class)
				.build();

		bootstrap.addBundle(guiceBundle);
	}

	@Override
	public void run(HelloWorldConfiguration configuration, final Environment environment) {
		
	}

}
