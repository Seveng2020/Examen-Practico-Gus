package com.examenpractico.backend.model;

import lombok.Data;

@Data
public class Resp {
    private boolean exito;
    private String mensaje;

    public Resp() {
    }

    public Resp(boolean b, String mensaje) {
        this.exito = b;
        this.mensaje = mensaje;

    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


}
