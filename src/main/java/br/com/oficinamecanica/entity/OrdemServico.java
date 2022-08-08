package br.com.oficinamecanica.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

/**
 * 
 */
@Data
@Entity
@Table(name= "tb_ordemservico")
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServico{
    
    @Id   // Esse atributo é exigido quando se aplica a anotação Entity 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz como será a estratégia de geraçao da pk
    private Long id;

    @Column(name="data_reg")
    private LocalDate dataDoRegistro;
}
