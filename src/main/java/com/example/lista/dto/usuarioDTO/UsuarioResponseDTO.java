package com.example.lista.dto.usuarioDTO;

import com.example.lista.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    @NotBlank(message = "Digite um nome valído")
    private String nome;
    @NotBlank(message = "Digite um email valído")
    @Email
    private String email;

    public UsuarioResponseDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}