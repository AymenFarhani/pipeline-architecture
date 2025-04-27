package com.pipeline;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.pipeline.routers.PipelineRouter;

@SpringBootApplication(
    scanBasePackages = "com.pipeline",
    exclude = {}
)
public class PipelineArchitectureApplication {

	public static void main(String[] args) {
		// 1. First get the Spring context
		ConfigurableApplicationContext pipeline = SpringApplication.run(PipelineArchitectureApplication.class, args);
		// 2. THEN get CamelContext
		CamelContext camelContext = pipeline.getBean(CamelContext.class);
        System.out.println("✅ CamelContext FOUND: " + (camelContext != null));
		// 3. Send test message
		camelContext.createProducerTemplate().sendBody("direct:start", "Hello, Camel!");
	}

	@Bean
    public CamelContext camelContext() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new PipelineRouter()); // Add your route class
        context.start(); // Start immediately
        return context;
    }
}

