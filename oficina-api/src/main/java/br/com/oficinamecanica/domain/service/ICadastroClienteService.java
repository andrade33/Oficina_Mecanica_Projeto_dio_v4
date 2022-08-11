///////////////////////////////////////////////////////////////////
package br.com.oficinamecanica.domain.service;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
import br.com.oficinamecanica.domain.models.Cliente;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
public interface ICadastroClienteService {
	public Cliente salvar(Cliente novoCliente);
	public void remover(Long clienteId);
	//public Cliente existsById(Cliente clienteId);
}
///////////////////////////////////////////////////////////////////