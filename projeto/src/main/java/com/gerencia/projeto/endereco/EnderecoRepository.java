package com.gerencia.projeto.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerencia.projeto.endereco.enums.TipoEnderco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByPessoaId(Long pessoaId);
    
    Endereco findByPessoaIdAndTipo(Long pessoaId, TipoEnderco tipo);
}
