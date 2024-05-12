package com.Library_Management_System.Repos;

import com.Library_Management_System.Entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    BorrowingRecord findByBookIdAndPatronIdAndReturnDateIsNull(Long bookId, Long patronId);
}
