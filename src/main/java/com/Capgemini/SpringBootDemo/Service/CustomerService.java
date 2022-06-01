package com.Capgemini.SpringBootDemo.Service;

import com.Capgemini.SpringBootDemo.Model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> saveCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomerById(Integer customerId);

    List<Customer> deleteCustomer(Integer customerId);

    public List<Customer> updateCustomer(Customer customer);

    Customer updateNameAndAccountType(int id, String name, String accountType);

    public List<Customer> FirstNameStartsWith(String firstName);

//    public List<Customer> FirstALastO();
    public List<Customer> findAllLastNameContainsOAsChar(String lastName);

    public List<String> getAllCustomerNames();

}