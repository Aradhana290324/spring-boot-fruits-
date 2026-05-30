package com.GuruFruit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.GuruFruit.entity.Customer;
import com.GuruFruit.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // SAVE CUSTOMER

    @PostMapping
    public Customer saveCustomer(
            @RequestBody Customer customer
    ) {

        Optional<Customer> existingCustomer =
                customerRepository.findByMobile(
                        customer.getMobile()
                );

        // IF CUSTOMER EXISTS → UPDATE

        if (existingCustomer.isPresent()) {

            Customer oldCustomer =
                    existingCustomer.get();

            oldCustomer.setName(
                    customer.getName()
            );

            oldCustomer.setAddress(
                    customer.getAddress()
            );

            oldCustomer.setLandmark(
                    customer.getLandmark()
            );

            oldCustomer.setPincode(
                    customer.getPincode()
            );

            oldCustomer.setCity(
                    customer.getCity()
            );

            oldCustomer.setBuildingNumber(
                    customer.getBuildingNumber()
            );

            oldCustomer.setNotes(
                    customer.getNotes()
            );

            return customerRepository.save(
                    oldCustomer
            );
        }

        // NEW CUSTOMER

        return customerRepository.save(
                customer
        );
    }

    // GET CUSTOMER

    @GetMapping("/{mobile}")
    public Customer getCustomer(
            @PathVariable String mobile
    ) {

        Optional<Customer> customer =
                customerRepository.findByMobile(
                        mobile
                );

        return customer.orElse(null);
    }
    @PutMapping("/{mobile}")
    public Customer updateCustomer(
            @PathVariable String mobile,
            @RequestBody Customer updatedCustomer
    ) {

        Optional<Customer> existingCustomer =
                customerRepository.findByMobile(mobile);

        if (existingCustomer.isPresent()) {

            Customer customer =
                    existingCustomer.get();

            customer.setName(
                    updatedCustomer.getName()
            );

            customer.setAddress(
                    updatedCustomer.getAddress()
            );

            customer.setLandmark(
                    updatedCustomer.getLandmark()
            );

            customer.setPincode(
                    updatedCustomer.getPincode()
            );

            customer.setCity(
                    updatedCustomer.getCity()
            );

            customer.setBuildingNumber(
                    updatedCustomer.getBuildingNumber()
            );

            customer.setNotes(
                    updatedCustomer.getNotes()
            );

            return customerRepository.save(customer);
        }

        return null;
    }
}