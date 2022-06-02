package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.Models.Product;
import ru.gb.webapp.Repo.ProductRepo;

import java.util.List;

@Service
public class ProductsService {

    private ProductRepo productRepository;

    @Autowired
    public ProductsService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProduct(Long id) {
        return productRepository.getProduct(id);
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }
}