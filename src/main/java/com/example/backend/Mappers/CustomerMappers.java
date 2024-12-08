package com.example.backend.Mappers;

import com.example.backend.DTO.CustomerDTO;
import com.example.backend.Entity.Customer;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMappers {
    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);

    List<CustomerDTO> toDTOList(List<Customer> customers);
}