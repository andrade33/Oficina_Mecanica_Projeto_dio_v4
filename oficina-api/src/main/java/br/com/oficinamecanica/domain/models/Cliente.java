///////////////////////////////////////////////////////////////////
package br.com.oficinamecanica.domain.models;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
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

    @Column(name= "CPF", unique = true)
    private String cpf;

    @NotBlank
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Size(max = 255)
	private String endereco;
	
	@NotBlank
	@Size(max = 255)
	//@Email
	private String email;
	
	@Column(name = "phone")
	@Size(max = 20)
	private String telefone;

}
///////////////////////////////////////////////////////////////////
