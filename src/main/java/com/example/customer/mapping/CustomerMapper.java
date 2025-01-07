package com.example.customer.mapping;

import com.example.customer.mapping.CustomerDto;
import com.example.customer.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    default CustomerDto toDTO(CustomerEntity entity) {
        return new CustomerDto.Builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .salary(entity.getSalary())
                .build();
    }

    default CustomerEntity toEntity(CustomerDto dto) {
        return new CustomerEntity.Builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .salary(dto.getSalary())
                .build();
    }
}
