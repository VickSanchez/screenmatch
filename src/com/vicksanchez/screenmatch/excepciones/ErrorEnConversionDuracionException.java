package com.vicksanchez.screenmatch.excepciones;

public class ErrorEnConversionDuracionException extends RuntimeException {

    private String mensaje;

    public ErrorEnConversionDuracionException(String mensaje) {
        this.mensaje= mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
