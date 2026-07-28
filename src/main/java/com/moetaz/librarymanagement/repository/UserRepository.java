package com.moetaz.librarymanagement.repository;

import com.moetaz.librarymanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
