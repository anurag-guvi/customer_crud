package com.example.customer.mapping;

public class CustomerDto {
    private Integer id;
    private String name;
    private String address;
    private Integer salary;

    private CustomerDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.salary = builder.salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getSalary() {
        return salary;
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

        public CustomerDto build() {
            return new CustomerDto(this);
        }
    }
}
