package com.example.customer;


import com.example.customer.entity.CustomerEntity;
import com.example.customer.repo.CustomerRepo;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class customerControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public CustomerRepo repo;

    @Test
    void findAllCustomers() throws Exception {
        mockMvc.perform(get("/main/customers"))
                .andExpect(status().isOk());

    }

    @Test
    void createCustomer() throws Exception {
        String json = "{\"id\":1,\"name\":\"John Doe\",\"address\":\"123 Main St\",\"salary\":5000}";
        mockMvc.perform(post("/main/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void findCustomerById() throws Exception {
        CustomerEntity customer = new CustomerEntity.Builder()
                .id(1)
                .name("John Doe")
                .address("123 Main St")
                .salary(5000)
                .build();
        repo.save(customer);

        mockMvc.perform(get("/main/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }


    @Test
    void updateCustomer() throws Exception {
        CustomerEntity customer = new CustomerEntity.Builder()
                .id(1)
                .name("John Doe")
                .address("123 Main St")
                .salary(5000)
                .build();
        repo.save(customer);

        String updatedJson = "{\"name\": \"Jane Doe\", \"address\": \"456 Avenue\", \"salary\": 6000}";
        mockMvc.perform(put("/main/customers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"));
    }

    @Test
    void deleteCustomer() throws Exception {
        CustomerEntity customer = new CustomerEntity.Builder()
                .id(1)
                .name("John Doe")
                .address("123 Street")
                .salary(5000)
                .build();
        repo.save(customer);

        mockMvc.perform(delete("/main/customers/1"))
                .andExpect(status().isNoContent());
    }

}
