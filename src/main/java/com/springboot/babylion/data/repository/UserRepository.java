package com.springboot.babylion.data.repository;

import com.springboot.babylion.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User getByEmail(String email);

}
