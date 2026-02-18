package com.example.lista.dto.usuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "Digite um nome valído")
    private String nome;
    @NotBlank(message = "Digite um email valído") @Email
    private String email;
    @NotBlank(message = "Digite uma senha valída")
    @Size(min = 6, max = 25)
    private String senha;
}