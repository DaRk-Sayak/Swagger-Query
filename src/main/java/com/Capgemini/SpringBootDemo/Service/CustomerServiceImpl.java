package com.Capgemini.SpringBootDemo.Service;

import com.Capgemini.SpringBootDemo.Model.Account;
import com.Capgemini.SpringBootDemo.Model.Customer;
import com.Capgemini.SpringBootDemo.Repository.AccountRepository;
import com.Capgemini.SpringBootDemo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Customer> saveCustomer(Customer customer){

        customerRepository.save(customer);
        for(Account account : customer.getAccounts()){
            account.setCustomer(customer);
            accountRepository.save(account);
        }

        return getCustomers();
    }


    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> optaddress = customerRepository.findById(customerId);

        return optaddress.get();


    }

    @Override
    public List<Customer> deleteCustomer(Integer customerId) {
        Optional<Customer> optaddress = customerRepository.findById(customerId);
        customerRepository.delete(optaddress.get());
       return getCustomers();

    }

    @Override
    public List<Customer> updateCustomer(Customer customer) {
        customerRepository.save(customer);
        for(Account account : customer.getAccounts()){
            account.setCustomer(customer);
            accountRepository.save(account);
        }

        return getCustomers();
        }

    @Override
    public Customer updateNameAndAccountType(int id, String name, String accountType) {
        Optional<Customer> customer=customerRepository.findById(id);
        customer.get().setFirstName(name);
        for (Account account:customer.get().getAccounts())
            account.setAccountType(accountType);
        return customerRepository.save(customer.get());
    }

    @Override
    public List<Customer> FirstNameStartsWith(String firstName) {
        return customerRepository.FirstNameStartsWith(firstName);
    }

//    @Override
//    public List<Customer> FirstALastO() {
//        return customerRepository.FirstALastO();
//    }x

    @Override
    public List<Customer> findAllLastNameContainsOAsChar(String lastName) {
        String str = "_"+lastName+"%";
        System.out.println(str);
        return customerRepository.findAllLastNameContainsOAsChar(str);

    }

    @Override
    public List<String> getAllCustomerNames() {
        List<String> names=new ArrayList<String>();
        List<Customer>customers=customerRepository.getAllCustomerNames();
        names= customers.stream().map(customer ->{
            return customer.getFirstName()+" "+customer.getLastName();
        }).collect(Collectors.toList());
        return names;
    }


}


