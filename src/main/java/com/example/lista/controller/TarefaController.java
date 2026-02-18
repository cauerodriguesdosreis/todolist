package com.example.lista.controller;

import com.example.lista.dto.tarefaDTO.TarefaRequestDTO;
import com.example.lista.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listAllTarefa(){
        return ResponseEntity.ok(tarefaService.listAllTarefa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTarefaById(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.getTarefaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarefaById(@PathVariable Long id){
        tarefaService.deleteTarefaById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTarefa (@PathVariable Long id, @RequestBody @Valid TarefaRequestDTO dto){
        return ResponseEntity.ok(tarefaService.updateTarefaById(id, dto));
    }


}