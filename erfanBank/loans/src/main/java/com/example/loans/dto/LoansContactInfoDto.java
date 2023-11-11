package com.example.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loans")
@Getter
@Setter
public class LoansContactInfoDto {

    private String meesage;
    private Map<String,String> contactDetails;
    private List<String> onCallSupport;
}
