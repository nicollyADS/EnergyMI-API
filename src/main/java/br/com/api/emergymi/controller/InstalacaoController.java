package br.com.api.emergymi.controller;

import br.com.api.emergymi.dto.instalacao.AtualizacaoInstalacaoDto;
import br.com.api.emergymi.dto.instalacao.CadastroInstalacaoDto;
import br.com.api.emergymi.dto.instalacao.DetalhesInstalacaoDto;
import br.com.api.emergymi.model.Instalacao;
import br.com.api.emergymi.repository.InstalacaoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("instalacoes")
public class InstalacaoController {
    @Autowired
    private InstalacaoRepository instalacaoRepository;


    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesInstalacaoDto>> get(Pageable pageable){
        var instalacao = instalacaoRepository.findAll(pageable)
                .stream().map(DetalhesInstalacaoDto::new).toList();
        return ResponseEntity.ok(instalacao);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesInstalacaoDto> get(@PathVariable("id")Long id){
        var instalacao = instalacaoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesInstalacaoDto(instalacao));
    }

    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesInstalacaoDto> post(@RequestBody CadastroInstalacaoDto instalacaoDto,
                                                       UriComponentsBuilder uriBuilder){
        var instalacao = new Instalacao(instalacaoDto);
        instalacaoRepository.save(instalacao);
        var uri = uriBuilder.path("instalacoes/{id}").buildAndExpand(instalacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesInstalacaoDto(instalacao));
    }

    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        instalacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesInstalacaoDto> put(@PathVariable("id")Long id,
                                                      @RequestBody AtualizacaoInstalacaoDto dto){
        var instalacao = instalacaoRepository.getReferenceById(id);
        instalacao.atualizarInformacoesInstalacao(dto);
        return ResponseEntity.ok(new DetalhesInstalacaoDto(instalacao));
    }


}