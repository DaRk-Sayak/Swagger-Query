package com.Capgemini.SpringBootDemo.Repository;

import com.Capgemini.SpringBootDemo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {



    public List<Customer> FirstNameStartsWith(String firstName);

    @Query("from Customer c where c.lastName like ?1")
    public List<Customer> findAllLastNameContainsOAsChar(String lastName);

    @Query("select new Customer(c.firstName, c.lastName) from Customer c ")
    public List<Customer> getAllCustomerNames();

}