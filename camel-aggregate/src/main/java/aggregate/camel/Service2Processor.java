package aggregate.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class Service2Processor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String requestBody = exchange.getIn().getBody(String.class);
        String response = "Response from Service2 for: " + requestBody;
        
        // Set correlation ID for aggregation
        exchange.getIn().setHeader("CamelCorrelationId", exchange.getExchangeId());
        exchange.getIn().setBody(response);
    }
}
