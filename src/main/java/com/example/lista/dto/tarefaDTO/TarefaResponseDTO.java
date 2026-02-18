package com.example.lista.dto.tarefaDTO;

import com.example.lista.entity.Tarefa;
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
public class TarefaResponseDTO {

    private Long id;
    @NotBlank(message = "Digite um nome valido")
    private String nome;
    @NotBlank(message = "Digite uma descrição valido")
    private String descricao;
    private Status status;
    private Boolean concluida;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private Long usuarioId;

    public TarefaResponseDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.nome = tarefa.getNome();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.concluida = tarefa.getConcluida();
        this.dtInicio = tarefa.getDtInicio();
        this.dtFim = tarefa.getDtFim();
        if (tarefa.getUsuario() != null) {
            this.usuarioId = tarefa.getUsuario().getId();
        }
    }
}
