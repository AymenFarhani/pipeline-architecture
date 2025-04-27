package com.pipeline.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.pipeline.filters.FilterProcessor;

@Component
public class PipelineRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
            .pipeline()
                .process(new FilterProcessor("Step 1: Validate"))
                .process(new FilterProcessor("Step 2: Transform"))
                .process(new FilterProcessor("Step 3: Store"))
                .to("log:output");
    }
    
}
