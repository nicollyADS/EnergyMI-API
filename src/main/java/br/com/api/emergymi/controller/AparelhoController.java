package br.com.api.emergymi.controller;

import br.com.api.emergymi.dto.aparelho.AtualizacaoAparelhoDto;
import br.com.api.emergymi.dto.aparelho.CadastroAparelhoDto;
import br.com.api.emergymi.dto.aparelho.DetalhesAparelhoDto;
import br.com.api.emergymi.model.Aparelho;
import br.com.api.emergymi.repository.AparelhoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("aparelhos")
public class AparelhoController {
    @Autowired
    private AparelhoRepository aparelhoRepository;


    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesAparelhoDto>> get(Pageable pageable){
        var aparelho = aparelhoRepository.findAll(pageable)
                .stream().map(DetalhesAparelhoDto::new).toList();
        return ResponseEntity.ok(aparelho);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesAparelhoDto> get(@PathVariable("id")Long id){
        var aparelho = aparelhoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesAparelhoDto(aparelho));
    }

    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesAparelhoDto> post(@RequestBody CadastroAparelhoDto aparelhoDto,
                                                       UriComponentsBuilder uriBuilder){
        var aparelho = new Aparelho(aparelhoDto);
        aparelhoRepository.save(aparelho);
        var uri = uriBuilder.path("aparelhos/{id}").buildAndExpand(aparelho.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesAparelhoDto(aparelho));
    }

    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        aparelhoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesAparelhoDto> put(@PathVariable("id")Long id,
                                                      @RequestBody AtualizacaoAparelhoDto dto){
        var aparelho = aparelhoRepository.getReferenceById(id);
        aparelho.atualizarInformacoesAparelho(dto);
        return ResponseEntity.ok(new DetalhesAparelhoDto(aparelho));
    }


}