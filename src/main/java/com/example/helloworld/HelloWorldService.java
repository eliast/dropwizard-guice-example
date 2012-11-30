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
		bootstrap.addBundle(new GuiceBundle()
			.addModule(new HelloWorldModule())
			.enableAutoConfig(getClass().getPackage().getName())
		);
	}

	@Override
	public void run(HelloWorldConfiguration configuration, final Environment environment) {
		
	}

}
