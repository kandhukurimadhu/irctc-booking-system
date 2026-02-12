package com.irctc.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.irctc.booking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
