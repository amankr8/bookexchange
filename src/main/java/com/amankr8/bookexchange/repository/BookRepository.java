package com.amankr8.bookexchange.repository;

import com.amankr8.bookexchange.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // All CRUD database methods
}
