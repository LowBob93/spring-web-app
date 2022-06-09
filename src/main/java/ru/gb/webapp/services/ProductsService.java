package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.Models.Product;
import ru.gb.webapp.Repo.ProductDao;

import java.util.List;

@Service
public class ProductsService {

    private ProductDao productDao;

    @Autowired
    public ProductsService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getProduct(Long id) {
        return productDao.findById(id);
    }


    public void saveProduct(Product product) {
        productDao.saveOrUpdate(product);
    }

    public void priceUp(Long id) {
        productDao.priceUp(getProduct(id));
    }

    public void priceDown(Long id) {
        productDao.priceDown(getProduct(id));
    }
}