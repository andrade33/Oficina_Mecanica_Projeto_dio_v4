///////////////////////////////////////////////////////////////////
package br.com.oficinamecanica.domain.service.impl_service;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.oficinamecanica.domain.service.IGestaoOrdemServicoService;
import br.com.oficinamecanica.domain.exception.DomainException;
import br.com.oficinamecanica.domain.models.Cliente;
import br.com.oficinamecanica.domain.models.OrdemServico;
import br.com.oficinamecanica.domain.models.StatusOrdemServico;
import br.com.oficinamecanica.domain.repository.ClienteRepository;
import br.com.oficinamecanica.domain.repository.OrdemServicoRepository;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
@Service
public class GestaoOrdemServicoServiceImpl implements IGestaoOrdemServicoService  {

	///////////////////////////////////////////////////////////////////
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;	
	@Autowired
	private ClienteRepository clienteRepository;
	///////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////
	public OrdemServico registrar(OrdemServico ordemServico) {
		
		Cliente clienteExistente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new DomainException("Cliente não encontrado."));
		ordemServico.setCliente(clienteExistente);
		ordemServico.setStatusOrdemServico(StatusOrdemServico.ABERTA);
		//ordemServico.setDataAbertura(OffsetDateTime.now());
		return ordemServicoRepository.save(ordemServico);
	}
	///////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////
	public void remover(Long ordemServicoId) {
		
		OrdemServico ordemServicoProcurada = encontrarOrdemServico(ordemServicoId);
		
		ordemServicoRepository.delete(ordemServicoProcurada);
		
	}
	///////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////
	public void finalizar(Long ordemServicoId) {
		
		OrdemServico ordemServicoProcurada = encontrarOrdemServico(ordemServicoId);
		
		ordemServicoProcurada.finalizarOrdemServico();
		
		ordemServicoRepository.save(ordemServicoProcurada);
		
	}
	///////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////
	//Esse metodo era privadi
	public OrdemServico encontrarOrdemServico(Long ordemServicoId) {
		OrdemServico ordemServicoProcurada = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new DomainException("Ordem de serviço não encontrado"));
		return ordemServicoProcurada;
	}
	///////////////////////////////////////////////////////////////////
}
