package com.Library_Management_System.Services;

// BorrowingRecordService.java
import com.Library_Management_System.Entities.Book;
import com.Library_Management_System.Entities.BorrowingRecord;
import com.Library_Management_System.Entities.Patron;
import com.Library_Management_System.Repos.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private PatronService patronService;

    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookService.getBookById(bookId);
        Patron patron = patronService.getPatronById(patronId);
        if (book != null && patron != null) {
            BorrowingRecord borrowingRecord = new BorrowingRecord();
            borrowingRecord.setBook(book);
            borrowingRecord.setPatron(patron);
            borrowingRecord.setBorrowDate(new Date());
            return borrowingRecordRepository.save(borrowingRecord);
        }
        return null;
    }

    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);
        if (borrowingRecord != null) {
            borrowingRecord.setReturnDate(new Date());
            return borrowingRecordRepository.save(borrowingRecord);
        }
        return null;
    }
}
