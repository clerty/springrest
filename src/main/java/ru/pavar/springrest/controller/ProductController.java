package ru.pavar.springrest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pavar.springrest.model.Product;
import ru.pavar.springrest.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = "application/hal+json")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<Product>> getAll() {
        List<Product> products = productService.getAll();
        //products.add(linkTo(methodOn(ProductController.class).getAll().withSelfRel()));
        return ResponseEntity.ok(CollectionModel.of(products));
    }

    @GetMapping("/{articleNumber}")
    public ResponseEntity<Product> get(@PathVariable int articleNumber) {
        Product product = productService.get(articleNumber);
        product.add(linkTo(methodOn(ProductController.class).get(articleNumber)).withSelfRel());
        //product.add(linkTo(methodOn(ProductController.class).getAll()));
        return ResponseEntity.ok(product);
    }
//    @GetMapping("/{articleNumber}")
//    ResponseEntity<EntityModel<Product>> findOne(@PathVariable int articleNumber) {
//        return productService.F
//    }
//    @GetMapping("/all")
//    public List<Product> getAllProducts() {
//        return productService.getAll();
//    }
//
//    @GetMapping("/{articleNumber}")
//    public Product getProductByArticleNumber(@PathVariable int articleNumber) {
//        return productService.getByArticleNumber(articleNumber);
//    }
//
//    @GetMapping("/add")
//    public Product addProduct(@RequestParam int articleNumber, @RequestParam String name, @RequestParam String type, @RequestParam(required = false) String size, @RequestParam(required = false) String color, @RequestParam int price) {
//        Product product = new Product(articleNumber, name, type, size, color, price);
//        productService.add(product);
//        return product;
//    }
//
//    @GetMapping("/delete")
//    public String deleteProduct(@RequestParam int articleNumber) {
//        productService.delete(articleNumber);
//        return "\"deleted\"";
//    }
//
//    @GetMapping("/edit")
//    public void editProduct() {
//        //productService
//    }
}

// ?articleNumber={articleNumber}&name={name}&type={type}&size={size}&color={color}&price={price}