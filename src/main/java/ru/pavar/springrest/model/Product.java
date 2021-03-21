package ru.pavar.springrest.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor//(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
public class Product extends RepresentationModel<Product> {
    @Id
    private int articleNumber;
    @NonNull
    private String name;
    @NonNull
    private String type;
    private String size;
    private String color;
    private int price;
}
