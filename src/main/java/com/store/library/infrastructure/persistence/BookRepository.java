package com.store.library.infrastructure.persistence;

import com.store.library.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByAuthorAndTitle(String author, String title);
}
