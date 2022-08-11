///////////////////////////////////////////////////////////////////
package br.com.oficinamecanica.api.controller;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.oficinamecanica.domain.models.Cliente;
import br.com.oficinamecanica.domain.service.impl_service.CadastroClienteServiceImpl;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
/*
 * O controller é o ponto de entrada das requisições (Requests).
 * Ao chegar a requisicação aqui ela traz um tipo de request embutido. 
 * Por exemplo: Get / Post / Delete etc
 * Es
 */
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
@RestController
@RequestMapping (value = "/clientes")
public class ClienteController {
    
    ////////////////////////////////////////////////////////////////
    // Injetando dependência
    @Autowired
    private CadastroClienteServiceImpl service; 
    ////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////
    //Nesse metodo não precisa de complemento na anotação.
    @PostMapping
    public ResponseEntity<Cliente> creating(@Valid @RequestBody Cliente c){
        return ResponseEntity.ok(service.salvar(c));
    }
    ////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> removing (@PathVariable Long clienteId){
        service.remover(clienteId);
        return null;
    }
    ////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////
    /* 
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente clienteAtualizado) {
    
        if (!clientRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
         }
    
        clienteAtualizado.setId(clienteId);
        cadastroClienteService.salvar(clienteAtualizado);
    
        return ResponseEntity.ok(clienteAtualizado);
    }*/
}
////////////////////////////////////////////////////////////////
