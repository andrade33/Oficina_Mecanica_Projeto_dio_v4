package br.com.oficinamecanica.service;

import java.util.List;

import br.com.oficinamecanica.entity.Cliente;
import br.com.oficinamecanica.entity.form.ClienteForm;

public interface IClienteService {
    Cliente serviceCreateCli(ClienteForm form);
    List<Cliente> servicefindAllCli();
    Cliente serviceFindByIdCli(Long id);
}
