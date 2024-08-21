package com.personal.zeitplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.personal.zeitplan.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
