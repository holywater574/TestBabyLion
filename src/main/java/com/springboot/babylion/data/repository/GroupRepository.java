package com.springboot.babylion.data.repository;

import com.springboot.babylion.data.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}