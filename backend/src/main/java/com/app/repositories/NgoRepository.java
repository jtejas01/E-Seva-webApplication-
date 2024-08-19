package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.NgoEntity;

public interface NgoRepository extends JpaRepository<NgoEntity, Long> {
   Optional<NgoEntity> findByEmailAndPassword(String email, String password);
}
