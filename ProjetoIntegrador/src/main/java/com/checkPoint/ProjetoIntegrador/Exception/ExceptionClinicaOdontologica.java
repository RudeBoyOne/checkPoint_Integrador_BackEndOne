package com.checkPoint.ProjetoIntegrador.Exception;

public class ExceptionClinicaOdontologica extends RuntimeException{

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
