package com.example.lista.service;

import com.example.lista.dto.tarefaDTO.TarefaRequestDTO;
import com.example.lista.dto.tarefaDTO.TarefaResponseDTO;
import com.example.lista.entity.Tarefa;
import com.example.lista.entity.Usuario;
import com.example.lista.exception.tarefaException.TarefaNotFoundException;
import com.example.lista.exception.usuarioException.UsuarioNotFoundException;
import com.example.lista.repository.TarefaRepository;
import com.example.lista.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;
    private UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public TarefaResponseDTO createTarefaForUsuario(Long usuarioId, @Valid TarefaRequestDTO dto){
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(UsuarioNotFoundException::new);
        Tarefa tarefa = new Tarefa(TarefaRequestDTO.class.cast(dto));
        tarefa.setUsuario(usuario);
        tarefaRepository.save(tarefa);
        return new TarefaResponseDTO(tarefa);
    }

    public List<TarefaResponseDTO> listAllTarefa(){
        return tarefaRepository.findAll().stream().map(TarefaResponseDTO::new).toList();
    }

    public List<TarefaResponseDTO> listTarefasByUsuario(Long usuarioId){
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new UsuarioNotFoundException();
        }
        return tarefaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(TarefaResponseDTO::new)
                .toList();
    }

    public TarefaResponseDTO getTarefaById(Long id){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(TarefaNotFoundException::new);
        return new TarefaResponseDTO(tarefa);
    }

    public void deleteTarefaById(Long id){
        if (!tarefaRepository.existsById(id)) {
            throw new TarefaNotFoundException();
        }
        tarefaRepository.deleteById(id);
    }

    public TarefaResponseDTO updateTarefaById(Long id, @Valid TarefaRequestDTO dto){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(TarefaNotFoundException::new);
        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setConcluida(dto.getConcluida() != null ? dto.getConcluida() : tarefa.getConcluida());
        tarefa.setDtFim(dto.getDtFim());
        tarefaRepository.save(tarefa);
        return new TarefaResponseDTO(tarefa);
    }
}
