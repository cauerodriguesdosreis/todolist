package com.example.lista.entity;

import com.example.lista.dto.usuarioDTO.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;


    public Usuario(UsuarioRequestDTO udto) {
        this.nome = udto.getNome();
        this.email = udto.getEmail();
        this.senha = udto.getSenha();
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefa> tarefas;
}
