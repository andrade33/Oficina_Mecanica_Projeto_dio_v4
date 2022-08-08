package com.api.oficinamecanica.service;

import java.util.List;

import com.api.oficinamecanica.entity.Cliente;
import com.api.oficinamecanica.entity.form.ClienteForm;

public interface IClienteService {
    Cliente serviceCreateCli(ClienteForm form);
    List<Cliente> servicefindAllCli();
    Cliente serviceFindByIdCli(Long id);
}
