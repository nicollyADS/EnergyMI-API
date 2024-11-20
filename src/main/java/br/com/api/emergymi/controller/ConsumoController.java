package br.com.api.emergymi.controller;

import br.com.api.emergymi.dto.consumo.AtualizacaoConsumoDto;
import br.com.api.emergymi.dto.consumo.CadastroConsumoDto;
import br.com.api.emergymi.dto.consumo.DetalhesConsumoDto;
import br.com.api.emergymi.model.Consumo;
import br.com.api.emergymi.repository.ConsumoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("consumos")
public class ConsumoController {
    @Autowired
    private ConsumoRepository consumoRepository;


    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesConsumoDto>> get(Pageable pageable){
        var consumo = consumoRepository.findAll(pageable)
                .stream().map(DetalhesConsumoDto::new).toList();
        return ResponseEntity.ok(consumo);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesConsumoDto> get(@PathVariable("id")Long id){
        var consumo = consumoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesConsumoDto(consumo));
    }

    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesConsumoDto> post(@RequestBody CadastroConsumoDto consumoDto,
                                                       UriComponentsBuilder uriBuilder){
        var consumo = new Consumo(consumoDto);
        consumoRepository.save(consumo);
        var uri = uriBuilder.path("consumos/{id}").buildAndExpand(consumo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesConsumoDto(consumo));
    }

    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        consumoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesConsumoDto> put(@PathVariable("id")Long id,
                                                      @RequestBody AtualizacaoConsumoDto dto){
        var consumo = consumoRepository.getReferenceById(id);
        consumo.atualizarInformacoesConsumo(dto);
        return ResponseEntity.ok(new DetalhesConsumoDto(consumo));
    }


}