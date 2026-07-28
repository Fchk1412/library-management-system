package com.moetaz.librarymanagement.repository;

import com.moetaz.librarymanagement.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository  extends JpaRepository<BorrowRecord,Integer> {
}


