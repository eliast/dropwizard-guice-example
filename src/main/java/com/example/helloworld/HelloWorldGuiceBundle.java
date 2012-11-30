package com.example.helloworld;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.google.inject.Module;
import com.hubspot.dropwizard.guice.GuiceBundle;

public class HelloWorldGuiceBundle extends GuiceBundle<HelloWorldConfiguration> {

	public HelloWorldGuiceBundle(String ... basePackages) {
		super(basePackages);
	}
	
	@Override
	protected Collection<? extends Module> configureModules(HelloWorldConfiguration configuration) {
		return Lists.newArrayList(new HelloWorldModule(configuration));
	}

	
}
