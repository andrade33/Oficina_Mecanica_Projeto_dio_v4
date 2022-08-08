package br.com.oficinamecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficinamecanica.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
