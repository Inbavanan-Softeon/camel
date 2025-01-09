package com.splitter.camel_splitter;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWorkListIdFilter {

    private final Set<String> uniqueIds = new HashSet<>();

    public void filterUnique(org.apache.camel.Exchange exchange) {
        String workListId = exchange.getIn().getBody(Map.class).get("workListId").toString();
        if (uniqueIds.add(workListId)) {
            exchange.getContext().createProducerTemplate()
                    .sendBody("log:uniqueWorkListId", "Unique workListId: " + workListId);
        }
    }
}

