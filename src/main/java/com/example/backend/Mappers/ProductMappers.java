package com.example.backend.Mappers;

import com.example.backend.DTO.ProductDTO;
import com.example.backend.Entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMappers {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
    List<ProductDTO> toDTOList(List<Product> products);
}
