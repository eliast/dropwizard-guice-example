package com.example.helloworld;

import java.util.Map;

import com.example.helloworld.guice.GuiceContainer;
import com.example.helloworld.guice.HelloWorldModule;
import com.example.helloworld.guice.JerseyModule;
import com.example.helloworld.health.TemplateHealthCheck;
import com.example.helloworld.resources.HelloWorldResource;
import com.google.inject.Guice;
import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.servlet.WebConfig;
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
	}

	@Override
	@SuppressWarnings("serial")
	public void run(HelloWorldConfiguration configuration,
			final Environment environment) {

		GuiceContainer container = new GuiceContainer() {
			protected ResourceConfig getDefaultResourceConfig(
					Map<String, Object> props, WebConfig webConfig)
					throws javax.servlet.ServletException {
				return environment.getJerseyResourceConfig();
			};
		};
		environment.setJerseyServletContainer(container);
		environment.addFilter(GuiceFilter.class, configuration
				.getHttpConfiguration().getRootPath());

		Guice.createInjector(new JerseyModule(container, configuration),
				new HelloWorldModule(configuration));

		environment.addResource(HelloWorldResource.class);
		
		final String template = configuration.getTemplate();
		environment.addHealthCheck(new TemplateHealthCheck(template));
	}

}