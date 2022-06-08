package ru.gb.webapp.Repo;


import org.springframework.stereotype.Component;
import ru.gb.webapp.Models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepo {

        private List<Product> productList;

        @PostConstruct
        public void init(){
            this.productList = new ArrayList<>(Arrays.asList(
                    new Product(1L, "Onion", 80.00),
                    new Product(2L, "Garlic", 120.00),
                    new Product(3L, "Carrot", 85.00),
                    new Product(4L, "Melon", 250.00),
                    new Product(5L, "Potato ", 70.00)
            ));
        }

    public List<Product> getProducts() {
        return productList;
        }
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

        public Product getProduct(Long id) {

            return productList.stream().filter(product -> product.getId().equals(id)).findFirst().get();
        }

        public void saveProduct(Product product) {
            productList.add(product);
        }


    public void delete(Product product){
             productList.remove(product);
    }

    public void priceUp(Product product) {

        product.setCost(product.getCost() + 1.0);
    }

    public void priceDown(Product product) {
        product.setCost(product.getCost() - 1.0);
    }




    }

