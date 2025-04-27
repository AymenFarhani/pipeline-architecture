package com.pipeline.filters;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FilterProcessor implements Processor{
    private final String filterName;

    public FilterProcessor(String filterName) {
        this.filterName = filterName;
    }   

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        String filterBody = filterName + " filter applied to: " + body;
        exchange.getIn().setBody(filterBody);
        System.out.println("🎉 FilterProcessor: " + filterBody);
    }

}
