package com.gerencia.projeto.endereco;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gerencia.projeto.endereco.enums.TipoEnderco;


@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Criar um novo endereço 
    @PostMapping
    public ResponseEntity<Endereco> criarEndereco( @RequestBody Endereco endereco) {
        return ResponseEntity.ok().body(enderecoRepository.save(endereco));
    }

    // Listar todos os edereços da pessoa 
    @GetMapping("/pessoa/{id}")
    public ResponseEntity <List<Endereco>> listarEnderecosPessoa(@PathVariable long id) {

        List<Endereco> enderecos = enderecoRepository.findByPessoaId(id);
        
        if(enderecos == null){
                throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Endereco não encontrado");
        }
        return ResponseEntity.ok().body(enderecos);  
    }

    // Buscar o endereço princiapl da pessoa
    @GetMapping("/principal/pessoa/{id}")
    public ResponseEntity <Endereco> getEnderecoPrincipalPessoa(@PathVariable long id) {

        Endereco enderecos = enderecoRepository.findByPessoaIdAndTipo(id,TipoEnderco.P);
        
        if(enderecos == null){
                throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Endereco Principal não encontrado");
        }
        return ResponseEntity.ok().body(enderecos);
    }
}
