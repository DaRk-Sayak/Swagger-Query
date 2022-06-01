package com.Capgemini.SpringBootDemo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Customer {

    @GeneratedValue
    @Id
    private int customerId;
    private String firstName;
    private String lastName;


    @OneToMany(targetEntity = Account.class,mappedBy = "customer",fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
    private List<Account> accounts;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }



    public Customer(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(int customerId, String firstName, String lastName, List<Account> accounts) {
        super();
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = accounts;
    }

    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", accounts=" + accounts + "]";
    }




}
