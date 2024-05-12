package com.Library_Management_System.Repos;

import com.Library_Management_System.Entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}

