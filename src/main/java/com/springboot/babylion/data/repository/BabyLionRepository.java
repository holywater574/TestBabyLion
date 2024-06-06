package com.springboot.babylion.data.repository;

import com.springboot.babylion.data.entity.BabyLion;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface BabyLionRepository extends JpaRepository<BabyLion, Long>{
    Optional<BabyLion> findByEmail(String email);

}
