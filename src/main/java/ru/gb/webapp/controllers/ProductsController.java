package ru.gb.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.webapp.Models.Product;
import ru.gb.webapp.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductsController {

    private ProductsService productService;

    @Autowired
    public ProductsController(ProductsService productService) {
        this.productService = productService;
    }


    //GET http://localhost:8189/app/show_all
    @GetMapping("/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    //GET http://localhost:8189/app/show/{id}
    @GetMapping("/show/{id}")
    public String showProductPageById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "product_info";
    }

    //GET http://localhost:8189/app/create
    @GetMapping("/create")
    public String createProduct() {

        return "create_product";
    }

    //POST http://localhost:8189/app/create
    @PostMapping("/create")
    public String saveProduct(@RequestParam String title, @RequestParam Double cost) {
        productService.saveProduct(new Product(title, cost));
        return "redirect:/show_all";
    }
    //GET http://localhost:8189/app/price_up/{id}
    @GetMapping("/price_up/{id}")
    public String priceUp(@PathVariable Long id) {
        productService.priceUp(id);
        return "redirect:/show_all";
    }

    //GET http://localhost:8189/app/price_down/{id}
    @GetMapping("/price_down/{id}")
    public String priceDown(@PathVariable Long id) {
        productService.priceDown(id);
        return "redirect:/show_all";
    }
}




