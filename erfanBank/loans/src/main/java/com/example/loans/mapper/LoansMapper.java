package com.example.loans.mapper;

import com.example.loans.dto.LoansDto;
import com.example.loans.entity.Loans;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoansMapper {

    public static Loans mapToLoans(LoansDto loansDto,Loans loans){
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setTotalLoan(loansDto.getTotalLoan());
        return loans;
    }

    public static LoansDto mapToLoansDto(Loans loans , LoansDto loansDto){
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setTotalLoan(loans.getTotalLoan());
        return loansDto;
    }
}
