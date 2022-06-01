package com.Capgemini.SpringBootDemo.Controller;

import com.Capgemini.SpringBootDemo.Model.Account;
import com.Capgemini.SpringBootDemo.Model.Customer;
import com.Capgemini.SpringBootDemo.Service.AccountService;
import com.Capgemini.SpringBootDemo.Service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Online wallet",description = "Create Cutomer with account details!")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;


    @ApiOperation(value = "To add details of a Customer",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Customer added successfully."),
            @ApiResponse(code = 401,message = "Wrong Inputs.")
    })
    @PostMapping("/customers")
    public ResponseEntity<List<Customer>> createCustomer(@RequestBody Customer customer)
    {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }


    @ApiOperation(value = "To get details of a Customer",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Customer received successfully."),
    })
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }


    @ApiOperation(value = "To get a Customer by Id",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Customer received successfully."),
            @ApiResponse(code = 404,message = "Customer Id Not found."),
            @ApiResponse(code = 401,message = "UserName password wrong!.")
    })
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "customerId") Integer customerId)
    {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }


    @ApiOperation(value = "To delete a Customer by Id",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Customer deleted successfully."),
            @ApiResponse(code = 404,message = "Customer Id Not found to delete."),
            @ApiResponse(code = 401,message = "UserName password wrong!.")
    })
    @DeleteMapping("/customers/{customerId}")
    public  ResponseEntity<List<Customer>> deleteCustomers(@PathVariable(name = "customerId")Integer customerId){
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);

    }


    @ApiOperation(value = "Update details of a customer.",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "All details updated successfully."),
            @ApiResponse(code = 404,message = "Customer details not found to update."),
            @ApiResponse(code = 401,message = "UserName password wrong!.")
    })
    @PutMapping("/updatecustomer")
    public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @GetMapping("/firstNameLike/{fname}")
    public ResponseEntity<List<Customer>> firstNameStartsWithA(@PathVariable(name = "fname") String fname)
    {
        return new ResponseEntity<>(customerService.FirstNameStartsWith(fname), HttpStatus.OK);
    }
    
    @GetMapping("/lastNameLike/{lname}")
    public ResponseEntity<List<Customer>> findAllLastNameContainsOAsChar(@PathVariable(name = "lname") String lname)
    {
        return new ResponseEntity<>(customerService.findAllLastNameContainsOAsChar(lname), HttpStatus.OK);
    }


    @ApiOperation(value = "Get All Accounts for a customer.",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "All accounts received successfully."),
            @ApiResponse(code = 404,message = "Customer Id Not found to get all accounts."),
            @ApiResponse(code = 401,message = "UserName password wrong!.")
    })
    @GetMapping("/getAccountByCustomerId/{id}")
    public ResponseEntity<List<Account>>findAccountByCustomerId(@PathVariable(name = "id")int id){
        return new ResponseEntity<List<Account>>(accountService.getAccountByCustomerId(id),HttpStatus.OK);
    }


    @ApiOperation(value = "Get First and Last name for all customer.",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "All Customer Full Names received successfully."),
    })
    @GetMapping("/getFullName")
    public ResponseEntity<List<String>>findByFullName(){
        return new ResponseEntity<List<String>>(customerService.getAllCustomerNames(),HttpStatus.OK);
    }
}
