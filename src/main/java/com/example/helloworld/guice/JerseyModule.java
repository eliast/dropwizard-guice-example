package com.example.helloworld.guice;

import com.sun.jersey.guice.JerseyServletModule;
import com.yammer.dropwizard.config.Configuration;

public class JerseyModule extends JerseyServletModule {
	private final GuiceContainer container;
	private final Configuration configuration;

	public JerseyModule(GuiceContainer container, Configuration configuration) {
		this.container = container;
		this.configuration = configuration;
	}

	@Override
	protected void configureServlets() {
		bind(GuiceContainer.class).toInstance(container);
		serve(configuration.getHttpConfiguration().getRootPath()).with(
				GuiceContainer.class);
	}
}
