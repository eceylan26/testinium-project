package com.testinium.bookstore.repositories;

import com.testinium.bookstore.entities.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository <BookStore, Integer> {}
