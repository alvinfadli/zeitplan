package com.personal.freelance_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.personal.freelance_manager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
