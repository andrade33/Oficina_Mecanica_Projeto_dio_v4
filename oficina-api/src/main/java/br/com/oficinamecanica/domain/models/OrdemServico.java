////////////////////////////////////////////
package br.com.oficinamecanica.domain.models;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
import br.com.oficinamecanica.domain.exception.DomainException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
//import java.time.LocalDate;
import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
@Data
@Entity
@Table(name = "tb_ordemservico")
@NoArgsConstructor
@AllArgsConstructor

public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    //@NotNull
    private Cliente cliente;

    //@NotBlank
    private String descricao;

    //@NotNull
    private BigDecimal preco;

    //@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "data_finalizacao")
	private OffsetDateTime dataFechamento;

    //@JsonProperty(access = Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusOrdemServico statusOrdemServico;


    public void setDataFechamento(OffsetDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

    public void finalizarOrdemServico() {
		if (naoPodeSerFinalizada()) {
			throw new DomainException("Ordem de serviço não pode ser finalizada.");
		}
		
		setStatusOrdemServico(StatusOrdemServico.FINALIZADA);
		setDataFechamento(OffsetDateTime.now());
	}
    private boolean podeSerFinalizada() {
		return getStatusOrdemServico().equals(StatusOrdemServico.ABERTA);
	}
    
    private boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
}
///////////////////////////////////////////////////////////////////