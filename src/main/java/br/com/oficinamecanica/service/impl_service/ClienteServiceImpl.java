package br.com.oficinamecanica.service.impl_service;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.oficinamecanica.repository.ClienteRepository;
import br.com.oficinamecanica.service.IClienteService;
import br.com.oficinamecanica.entity.Cliente;
import br.com.oficinamecanica.entity.form.ClienteForm;

@Service
public class ClienteServiceImpl implements IClienteService{
    
    @Autowired
    private ClienteRepository repository;


    @Override
    public Cliente serviceCreateCli(ClienteForm form) {
        Cliente cliente = new Cliente(); 
        cliente.setNome(form.getNome());
        cliente.setCpf(form.getCpf());
        
        return repository.save(cliente);
    }

    @Override
    public Cliente serviceFindByIdCli(Long id) {
        Cliente cli = repository.findById(id).get();
        return cli;
    }

    @Override
    public List<Cliente> servicefindAllCli() {
        List<Cliente> listCli = repository.findAll();
         return listCli;
    }
}
