package com.springboot.babylion.data.repository;

import com.springboot.babylion.data.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}