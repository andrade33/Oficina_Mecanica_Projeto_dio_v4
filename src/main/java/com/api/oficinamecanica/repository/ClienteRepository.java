package com.api.oficinamecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.oficinamecanica.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
