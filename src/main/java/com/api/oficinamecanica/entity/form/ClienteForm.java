package com.api.oficinamecanica.entity.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClienteForm {

    @NotEmpty (message = "Preencha o comapo corretamente")
    @Size(min = 3, max = 50, message = "'${valdateValue}' precisa estar entre {min} e {max}")
    private String nome;
    
    
    @Size(min = 3, max = 11, message = "'${valdateValue}' precisa estar entre {min} e {max}")
    @NotEmpty (message = "Preencha o comapo corretamente")
    private String cpf;
    
}
