package aggregate.camel;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;


public class CustomAggregationStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        // Combine the responses from both services
        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);

        String aggregatedResponse = String.format(
            "{ \"service1Data\": %s, \"service2Data\": %s }",
            oldBody,
            newBody
        );

        oldExchange.getIn().setBody(aggregatedResponse);
        return oldExchange;
    }
}

