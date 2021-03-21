package ru.pavar.springrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pavar.springrest.model.Product;
import ru.pavar.springrest.repository.ProductRepository;
import ru.pavar.springrest.service.IProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product add(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    @Transactional
    public void delete(int articleNumber) {
        productRepository.deleteById(articleNumber);
    }

    @Override
    @Transactional
    public Product edit(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product get(int articleNumber) {
        return productRepository.findById(articleNumber).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
