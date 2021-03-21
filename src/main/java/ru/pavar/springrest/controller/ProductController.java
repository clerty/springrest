package ru.pavar.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pavar.springrest.model.Product;
import ru.pavar.springrest.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{articleNumber}")
    public Product getProductByArticleNumber(@PathVariable int articleNumber) {
        return productService.getByArticleNumber(articleNumber);
    }

    @GetMapping("/add")
    public Product addProduct(@RequestParam int articleNumber, @RequestParam String name, @RequestParam String type, @RequestParam(required = false) String size, @RequestParam(required = false) String color, @RequestParam int price) {
        Product product = new Product(articleNumber, name, type, size, color, price);
        productService.add(product);
        return product;
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int articleNumber) {
        productService.delete(articleNumber);
        return "\"deleted\"";
    }

    @GetMapping("/edit")
    public void editProduct() {
        //productService
    }
}

// ?articleNumber={articleNumber}&name={name}&type={type}&size={size}&color={color}&price={price}