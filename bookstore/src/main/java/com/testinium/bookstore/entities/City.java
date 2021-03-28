package com.testinium.bookstore.entities;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ApiModel(description = "Details of City")
public class City {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String name;

    private double priceFactor;


}
