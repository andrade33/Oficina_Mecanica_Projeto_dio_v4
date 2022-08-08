package com.api.oficinamecanica.entity;

import javax.persistence.*;
import javax.persistence.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data      // Adiciona getter e setter com lombok (dependencia definida no pom.xml)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityScan
@Table(name= "tb_cliente")
public class Cliente {

    @Id   // Esse atributo é exigido quando se aplica a anotação Entity 
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Diz como será a estratégia de geraçao da pk
    private Long id;

    @Column(name= "NOME")
    private String nome;

    @Column(name= "CPF", unique = true)
    private String cpf;
}
