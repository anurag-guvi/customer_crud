package com.example.customer.service;

import com.example.customer.entity.CustomerEntity;
import com.example.customer.mapping.CustomerMapper;
import com.example.customer.repo.CustomerRepo;
import com.example.customer.mapping.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepo customerRepo;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;


    public CustomerDto saveCustomer(CustomerDto customerDto){
        CustomerEntity customerEntity = customerMapper.toEntity(customerDto);
        CustomerEntity savedEntity = customerRepo.save(customerEntity);
        return customerMapper.toDTO(savedEntity);
    }

    public List<CustomerDto> getAllCustomer(){
        List<CustomerEntity> customerEntities = (List<CustomerEntity>) customerRepo.findAll();
        return customerEntities.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CustomerDto> getCustomerById(Integer id){
        return customerRepo.findById(id)
                .map(customerMapper::toDTO);
    }

    public CustomerDto updateCustomer(Integer id, CustomerDto customerDto) {
        CustomerEntity existingCustomer = customerRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found with id: " + id));

        CustomerEntity updatedCustomer = new CustomerEntity.Builder()
                .id(existingCustomer.getId()) // Keep the existing ID
                .name(customerDto.getName())
                .address(customerDto.getAddress())
                .salary(customerDto.getSalary())
                .build();

        CustomerEntity savedCustomer = customerRepo.save(updatedCustomer);

        return customerMapper.toDTO(savedCustomer);
    }

    public void removeCustomer(Integer id){
        if(!customerRepo.existsById(id)) {
            throw new NoSuchElementException("Customer not found with id:" + id);
        }
        customerRepo.deleteById(id);
    }
}