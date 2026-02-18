package com.example.lista.exception.usuarioException;

public class EmptyUsuarioListException extends RuntimeException {
    public EmptyUsuarioListException() {
        super("Não há usuários cadastrados para listar");
    }
}
