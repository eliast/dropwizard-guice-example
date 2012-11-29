package com.example.helloworld.guice;

import com.example.helloworld.HelloWorldConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class HelloWorldModule extends AbstractModule {
	
	private final HelloWorldConfiguration configuration;
	
	public HelloWorldModule(HelloWorldConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	protected void configure() {
		bind(String.class).annotatedWith(Names.named("template")).toInstance(configuration.getTemplate());
		bind(String.class).annotatedWith(Names.named("defaultName")).toInstance(configuration.getDefaultName());
	}

}
