package com.example.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
public class AccountsCantactInfoDto {

    private String messgae;
    private Map<String,String> cantactDetails;
    private String onCallSupport;

}
