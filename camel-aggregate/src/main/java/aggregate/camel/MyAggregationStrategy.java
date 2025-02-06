package aggregate.camel;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

public class MyAggregationStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);

        // Combine the responses
        String aggregatedBody = oldBody + " " + newBody;

        oldExchange.getIn().setBody(aggregatedBody);
        return oldExchange;
    }
}