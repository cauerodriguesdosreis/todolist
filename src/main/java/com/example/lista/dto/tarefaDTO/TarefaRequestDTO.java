package com.example.lista.dto.tarefaDTO;

import com.example.lista.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaRequestDTO {

    @NotBlank(message = "Digite um nome válido.")
    private String nome;
    @NotBlank(message = "Digite uma descrição válida.")
    private String descricao;
    private Status status;
    private Boolean concluida;
    private LocalDate dtInicio;
    private LocalDate dtFim;

}