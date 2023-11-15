package com.example.getwayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseTraceFilter {

    @Autowired
    private FilterUtility filterUtility;

    private final static Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);

    @Bean
    public GlobalFilter postGlobalFilter(){
        return (exchange, chain) -> {
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
                String correlationId = filterUtility.getCorrelationId(httpHeaders);
                exchange.getResponse().getHeaders().add(filterUtility.CORRELATION_ID,correlationId);
                logger.debug("erfanbank_correlation_id has been UPDATED in ResponseTraceFilter {}", correlationId);
            }));
        };
    }
}
