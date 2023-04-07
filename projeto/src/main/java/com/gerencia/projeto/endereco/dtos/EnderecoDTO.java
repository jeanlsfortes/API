package com.gerencia.projeto.endereco.dtos;

import com.gerencia.projeto.endereco.enums.TipoEnderco;
import com.gerencia.projeto.pessoa.Pessoa;

import lombok.Data;

@Data
public class EnderecoDTO {
    
    private TipoEnderco tipo;

    private Pessoa pessoa;

    private String logradouro;

    private String cep;

    private Long numero;

    private String cidade;
}
