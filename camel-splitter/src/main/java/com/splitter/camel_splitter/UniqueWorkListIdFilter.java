package com.splitter.camel_splitter;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import java.util.*;

public class UniqueWorkListIdFilter {
    private final Set<String> uniqueIds = new HashSet<>();
    private final List<Map<String, Object>> uniqueItems = new ArrayList<>();

    public void filterUnique(Exchange exchange) {
        Map<String, Object> body = exchange.getIn().getBody(Map.class);
        String workListId = body.get("workListId").toString();

        if (uniqueIds.add(workListId)) {
            uniqueItems.add(body);
        }

        Message message = exchange.getIn();
        message.setBody(uniqueItems);
    }
}
