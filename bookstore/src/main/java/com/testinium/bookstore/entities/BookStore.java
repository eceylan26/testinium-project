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
@Entity
@Builder
@ApiModel(description = "Details of Book Store")
public class BookStore {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String name;

    @OneToOne
    private City city;

}
