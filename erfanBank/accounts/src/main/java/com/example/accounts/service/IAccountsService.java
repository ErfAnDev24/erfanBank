package com.example.accounts.service;

import com.example.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAcoount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);

}
