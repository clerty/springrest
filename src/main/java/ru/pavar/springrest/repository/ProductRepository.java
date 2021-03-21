package ru.pavar.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavar.springrest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
