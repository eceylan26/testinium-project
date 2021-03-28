package com.testinium.bookstore.repositories;

import com.testinium.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "Select * from book b JOIN book_book_store a " +
            "ON b.id =  a.book_id  where  b.id=?1",
            nativeQuery = true)
    List<Book> findAllBookByBookStoreId(int id);

    @Query(value = "Select * from book b JOIN category a " +
            "ON b.category_id  =  a.id  where  b.id=?1",
            nativeQuery = true)
    List<Book> findAllBookByCategoryId(int id);

    @Modifying
    @Query(value = "Delete from book_book_store b where  b.book_id=?1 AND b.book_store_id=?2",
            nativeQuery = true)
    void deleteBookFromBookStoreById(int bookId,int bookStoreId);


}
