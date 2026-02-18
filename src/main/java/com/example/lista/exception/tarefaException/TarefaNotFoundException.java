package com.example.lista.exception.tarefaException;

public class TarefaNotFoundException extends RuntimeException {
    public TarefaNotFoundException() {
        super("Tarefa não encontrada. Tente novamente.");
    }
}
