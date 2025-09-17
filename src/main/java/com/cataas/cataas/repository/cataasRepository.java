package com.cataas.cataas.repository;

import com.cataas.cataas.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cataasRepository extends JpaRepository<Cat, String> {
}
