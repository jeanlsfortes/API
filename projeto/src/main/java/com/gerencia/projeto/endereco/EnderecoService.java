package com.gerencia.projeto.endereco;

import java.util.List;

import com.gerencia.projeto.pessoa.Pessoa;



public interface EnderecoService {
    
    boolean verificaEndereço(List<Endereco> enderecos);

    Endereco getEnderecoPrincipal(Pessoa pessoa);
}

