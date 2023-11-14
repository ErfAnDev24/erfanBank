package com.example.getwayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class RequestTraceFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    private FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        if (filterUtility.getCorrelationId(httpHeaders) !=null){
            logger.debug("erfanbank_correlation_id has been FOUND in RequestTraceFilter {}",
                    filterUtility.getCorrelationId(httpHeaders));
        }else {
            String correlationId = generateCorrelationId();
            filterUtility.setCorrelationId(exchange,correlationId);
            logger.debug("erfanbank_correlation_id has been BUILT in RequestTraceFilter {}",
                    filterUtility.getCorrelationId(httpHeaders));
        }
        return chain.filter(exchange);
    }

    public String generateCorrelationId(){
        return java.util.UUID.randomUUID().toString();
    }
}
