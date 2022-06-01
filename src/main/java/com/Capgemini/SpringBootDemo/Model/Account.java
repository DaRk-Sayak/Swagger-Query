package com.Capgemini.SpringBootDemo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;


@SequenceGenerator(name = "accseq",initialValue = 102345,sequenceName = "accseq")
@Entity
public class Account {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "accseq")
    @Id
    private int accountNo;
    private String accountType;

    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate openingDate;
    private double openingBalance;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public LocalDate getOpeningDate() {
        return openingDate;
    }
    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
    public double getOpeningBalance() {
        return openingBalance;
    }
    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }
    public Account(int accountNo, String accountType, LocalDate openingDate, double openingBalance) {
        super();
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.openingDate = openingDate;
        this.openingBalance = openingBalance;
    }
    public Account() {
        super();
    }
    @Override
    public String toString() {
        return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", openingDate=" + openingDate
                + ", openingBalance=" + openingBalance + "]";
    }



}
