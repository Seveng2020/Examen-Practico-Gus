package com.examenpractico.backend.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "solicitud")
public class Solicitud {
    @MongoId
    private String id;
    private String nombre;
    private String dni;
    private String email;
    private String idObraSocial;
    private String idEspecialidad;

    public Solicitud() {
    }

    public Solicitud(String id, String nombre, String dni, String idObraSocial, String idEspecialidad) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.idObraSocial = idObraSocial;
        this.idEspecialidad = idEspecialidad;
    }


}
