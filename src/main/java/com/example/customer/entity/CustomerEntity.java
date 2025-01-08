package com.example.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    private Integer id;
    private String name;
    private String address;
    private Integer salary;

    // Default constructor required by JPA
    protected CustomerEntity() {
    }

    private CustomerEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.salary = builder.salary;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String address;
        private Integer salary;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder salary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(this);
        }
    }
}
