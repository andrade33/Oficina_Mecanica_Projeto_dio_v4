package com.api.oficinamecanica.entity.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EnderecoForm {

    @NotEmpty (message = "Preencha o comapo corretamente")
    @Size(min = 3, max = 50, message = "'${valdateValue}' precisa estar entre {min} e {max}")
    private String logradouro;
    
    
    @NotEmpty (message = "Preencha o comapo corretamente")
    @Size(min = 3, max = 5, message = "'${valdateValue}' precisa estar entre {min} e {max}")
    private String numero;
    

    @NotEmpty (message = "Preencha o comapo corretamente")
    @Size(min = 3, max = 50, message = "'${valdateValue}' precisa estar entre {min} e {max}")
    private String bairro;
    
    
    @NotEmpty (message = "Preencha o comapo corretamente")
    @Size(min = 3, max = 50, message = "'${valdateValue}' precisa estar entre {min} e {max}")
    private String complemento;

    @NotEmpty (message = "Preencha o comapo corretamente")
    private String cidade;
    
}
