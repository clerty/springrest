package ru.pavar.springrest.service;

import ru.pavar.springrest.model.Product;

import java.util.List;

public interface IProductService {

    Product add(Product product);
    void delete(int articleNumber);
    Product edit(Product product);
    Product get(int articleNumber);
    List<Product> getAll();

}