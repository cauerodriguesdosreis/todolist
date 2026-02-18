package com.example.lista.dto.usuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioErrorDTO {

    private int status;
    private String mensagem;
    private LocalDateTime dataHora;
}
