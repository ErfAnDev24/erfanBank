package com.example.getwayserver.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {

    public final static String CORRELATION_ID = "erfanbank_correlation_id";

    public String getCorrelationId(HttpHeaders httpHeaders){
        if(httpHeaders.get(CORRELATION_ID) !=null){
            List<String> headerList = httpHeaders.get(CORRELATION_ID);
            return headerList.stream().findFirst().get();
        }else
            return null;
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange , String name , String value){
        return exchange.mutate().request(exchange.getRequest().mutate().header(name,value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange , String correlationId){
        return setRequestHeader(exchange,CORRELATION_ID,correlationId);
    }
}
