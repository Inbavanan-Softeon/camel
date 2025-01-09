package com.splitter.camel_splitter;


import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import java.util.*;

public class GroupByWorkListId implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            // First exchange, initialize a map to hold unique workListIds
            Map<String, Object> aggregatedData = new LinkedHashMap<>();
            aggregatedData.put("workListId", newExchange.getIn().getBody(Map.class));
            newExchange.getIn().setBody(aggregatedData);
            return newExchange;
        } else {
            // Retrieve existing aggregated data
            Map<String, Object> aggregatedData = oldExchange.getIn().getBody(Map.class);
            Map<String, Object> currentItem = newExchange.getIn().getBody(Map.class);

            String workListId = currentItem.get("workListId").toString();
            if (!aggregatedData.containsKey(workListId)) {
                aggregatedData.put(workListId, currentItem);
            }
            oldExchange.getIn().setBody(aggregatedData);
            return oldExchange;
        }
    }
}
