package com.app.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entity.DonerEntity;

public interface DonerRepository extends JpaRepository<DonerEntity, Long> {
   Optional <DonerEntity> findByEmailAndPassword(String email,String password);
}

