package com.example.helloworld;

import javax.inject.Named;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.yammer.dropwizard.config.Configuration;

public class HelloWorldModule extends AbstractModule {
	
	@Override
	protected void configure() {

	}

	@Provides
	public HelloWorldConfiguration configuration(Configuration configuration) {
		return (HelloWorldConfiguration) configuration;
	}
	
	@Provides
	@Named("template")
	public String provideTemplate(HelloWorldConfiguration configuration) {
		return configuration.getTemplate();
	}

	@Provides
	@Named("defaultName")
	public String provideDefaultName(HelloWorldConfiguration configuration) {
		return configuration.getDefaultName();
	}

}
