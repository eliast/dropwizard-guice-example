package com.example.helloworld;

import javax.inject.Named;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class HelloWorldModule extends AbstractModule {
	
	@Override
	protected void configure() {

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
