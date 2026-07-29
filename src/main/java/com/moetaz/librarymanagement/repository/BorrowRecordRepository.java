package com.moetaz.librarymanagement.repository;

import com.moetaz.librarymanagement.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRecordRepository  extends JpaRepository<BorrowRecord,Integer> {

    Optional<BorrowRecord> findByBookIdAndReturnDateIsNull(Integer bookId);
}


