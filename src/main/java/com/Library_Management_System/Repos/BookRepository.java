package com.Library_Management_System.Repos;

import com.Library_Management_System.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}