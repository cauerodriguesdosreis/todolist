package com.example.lista.entity;

import com.example.lista.dto.tarefaDTO.TarefaRequestDTO;
import com.example.lista.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private Status status;
    private Boolean concluida;
    private LocalDate dtInicio;
    private LocalDate dtFim;

    public Tarefa(TarefaRequestDTO udto) {
        this.nome = udto.getNome();
        this.descricao = udto.getDescricao();
        this.status = udto.getStatus();
        this.concluida = udto.getConcluida() != null ? udto.getConcluida() : Boolean.FALSE;
        this.dtInicio = LocalDate.now();
        this.dtFim = udto.getDtFim();

    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}