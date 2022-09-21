package com.checkPoint.ProjetoIntegrador.domain.exception;

public class RecursoNaoEncontradoException extends ClinicaOdontologicaException {

    private static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException() {
    }

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "RecursoNaoEncontradoException{}";
    }
}
