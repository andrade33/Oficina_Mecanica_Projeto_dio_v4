package br.com.oficinamecanica.entity;

import javax.persistence.*;


import lombok.*;

@Data      // Adiciona getter e setter com lombok (dependencia definida no pom.xml)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "tb_endereco")
public class Endereco{
    
    @Id   // Esse atributo é exigido quando se aplica a anotação Entity 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz como será a estratégia de geraçao da pk
    private Long id;

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String complemento;
}
