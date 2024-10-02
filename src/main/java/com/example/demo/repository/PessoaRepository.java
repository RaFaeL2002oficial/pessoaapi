package com.example.demo.repository;

import com.example.demo.entity.pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<pessoa, UUID> {
}

