package com.example.lista.service;

import com.example.lista.dto.usuarioDTO.UsuarioRequestDTO;
import com.example.lista.dto.usuarioDTO.UsuarioResponseDTO;
import com.example.lista.entity.Usuario;
import com.example.lista.exception.usuarioException.CreateUsuarioException;
import com.example.lista.exception.usuarioException.EmptyUsuarioListException;
import com.example.lista.exception.usuarioException.UsuarioNotFoundException;
import com.example.lista.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO createUsuario(@Valid @RequestBody UsuarioRequestDTO dto){
        if (usuarioRepository.findAll().stream().anyMatch(usuario -> usuario.getEmail().equals(dto.getEmail()))){
            throw new CreateUsuarioException();
        }
        Usuario usuario = new Usuario(UsuarioRequestDTO.class.cast(dto));
        usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> listAllUsuario(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new EmptyUsuarioListException();
        }
        return usuarios.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    public UsuarioResponseDTO getUsuarioById(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException());
        return new UsuarioResponseDTO(usuario);
    }

    public void deleteUsuarioById(Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException();
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioResponseDTO updateUsuario(Long id, @Valid @RequestBody Usuario usuario){
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException();
        }
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }
}
