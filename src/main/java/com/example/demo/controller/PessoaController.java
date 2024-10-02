package com.example.demo.controller;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.entity.pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        pessoa pessoa = new pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());

        pessoa novaPessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<pessoa> buscarPessoaPorId(@PathVariable UUID id) {
        pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return ResponseEntity.ok(pessoa);
    }
}
