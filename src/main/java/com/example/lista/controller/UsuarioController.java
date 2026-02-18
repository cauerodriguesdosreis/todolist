package com.example.lista.controller;

import com.example.lista.dto.tarefaDTO.TarefaRequestDTO;
import com.example.lista.dto.usuarioDTO.UsuarioRequestDTO;
import com.example.lista.dto.usuarioDTO.UsuarioResponseDTO;
import com.example.lista.entity.Usuario;
import com.example.lista.service.TarefaService;
import com.example.lista.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private TarefaService tarefaService;

    public UsuarioController(UsuarioService usuarioService, TarefaService tarefaService) {
        this.usuarioService = usuarioService;
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUsuario (@RequestBody @Valid UsuarioRequestDTO dto){
        return ResponseEntity.ok(usuarioService.createUsuario(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listAllUsuario(){
        return ResponseEntity.ok(usuarioService.listAllUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteUsuarioById(@PathVariable Long id){
        usuarioService.deleteUsuarioById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario (@PathVariable Long id, @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuario));
    }

    @PostMapping("/{id}/tarefas")
    public ResponseEntity<?> createTarefaForUsuario(@PathVariable Long id,
                                                    @RequestBody @Valid TarefaRequestDTO dto) {
        return ResponseEntity.ok(tarefaService.createTarefaForUsuario(id, dto));
    }

    @GetMapping("/{id}/tarefas")
    public ResponseEntity<?> listTarefasByUsuario(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.listTarefasByUsuario(id));
    }
}