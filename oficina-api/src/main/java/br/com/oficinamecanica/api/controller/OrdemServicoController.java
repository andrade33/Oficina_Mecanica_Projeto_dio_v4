///////////////////////////////////////////////////////////////////
package br.com.oficinamecanica.api.controller;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
import java.util.List;
import javax.validation.Valid;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.oficinamecanica.api.model.OrdemServicoRepresentationModel;
import br.com.oficinamecanica.domain.models.OrdemServico;
import br.com.oficinamecanica.domain.repository.OrdemServicoRepository;
import br.com.oficinamecanica.domain.service.impl_service.GestaoOrdemServicoServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
@RestController
@RequestMapping (value = "/ordemservico")
public class OrdemServicoController {
    
    ////////////////////////////////////////////////////////////////
    // Injeção de dependência
    @Autowired
    private GestaoOrdemServicoServiceImpl service;
    @Autowired
	private OrdemServicoRepository ordemServicoRepository;
    //@Autowired
	private ModelMapper modelMapper;
	////////////////////////////////////////////////////////////////
    
	////////////////////////////////////////////////////////////////
    // Registrando
    @PostMapping
    public ResponseEntity<OrdemServico> fazerRegistro(@Valid @RequestBody OrdemServico ordemServico){
        return ResponseEntity.ok(service.registrar(ordemServico));
    }
    ////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////
    // Listando
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrdemServicoRepresentationModel> listar() {
        return converterParaOrdemServicoRepresentationModels(
            ordemServicoRepository.findAll());
    }
    ////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////
    private OrdemServicoRepresentationModel converterParaOrdemServicoRepresentationModel(OrdemServico ordemServico) {
        return modelMapper.map(ordemServico, OrdemServicoRepresentationModel.class);
	}
    ////////////////////////////////////////////////////////////////
	
    ////////////////////////////////////////////////////////////////
	private List<OrdemServicoRepresentationModel> converterParaOrdemServicoRepresentationModels(List<OrdemServico> ordensDeServico) {
        return ordensDeServico.stream()
        .map(ordem -> converterParaOrdemServicoRepresentationModel(ordem))
        .collect(Collectors.toList());
	}
    ////////////////////////////////////////////////////////////////
}
