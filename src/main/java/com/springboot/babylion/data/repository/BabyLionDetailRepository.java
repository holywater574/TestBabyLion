package com.springboot.babylion.data.repository;

import com.springboot.babylion.data.entity.BabyLionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BabyLionDetailRepository extends JpaRepository<BabyLionDetail, Long> {
}