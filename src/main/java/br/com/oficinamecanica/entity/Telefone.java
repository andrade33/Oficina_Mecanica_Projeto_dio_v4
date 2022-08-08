package br.com.oficinamecanica.entity;

import javax.persistence.*;
import lombok.*;

/**
 * 
 */
@Data      // Adiciona getter e setter com lombok (dependencia definida no pom.xml)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "tb_telefone")
public class Telefone {

    @Id   // Esse atributo é exigido quando se aplica a anotação Entity 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz como será a estratégia de geraçao da pk
    private Long id;
    
    private String telefone;
}
