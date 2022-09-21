package com.checkPoint.ProjetoIntegrador.domain.exception;

public class ClinicaOdontologicaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClinicaOdontologicaException() {
    }

    public ClinicaOdontologicaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ExceptionPaciente{}";
    }
}
