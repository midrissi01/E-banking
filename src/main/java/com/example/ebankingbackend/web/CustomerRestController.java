package com.example.ebankingbackend.web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.ebankingbackend.dtos.CustomerDTO;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;
import com.example.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerID) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerID);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping ("/customers/{customerID}")
    public CustomerDTO updateCustomer(@PathVariable Long customerID ,@RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerID);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
    }


}