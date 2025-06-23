package com.project.basic_crud.service;

import com.project.basic_crud.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    public Page<Product> getAllProducts(Pageable pageable);
    public Product getProductById(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Long id, Product productDetails);
    public void deleteProduct(Long id);
}
