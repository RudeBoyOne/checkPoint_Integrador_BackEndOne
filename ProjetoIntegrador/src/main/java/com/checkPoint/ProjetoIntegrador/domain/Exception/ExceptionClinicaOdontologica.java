package com.checkPoint.ProjetoIntegrador.domain.Exception;

public class ExceptionClinicaOdontologica extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExceptionClinicaOdontologica() {
    }

    public ExceptionClinicaOdontologica(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ExceptionPaciente{}";
    }
}
