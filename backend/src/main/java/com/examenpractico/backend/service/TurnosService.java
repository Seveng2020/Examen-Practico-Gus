package com.examenpractico.backend.service;


import com.examenpractico.backend.model.Especialidad;
import com.examenpractico.backend.model.ObraSocial;
import com.examenpractico.backend.model.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnosService {

    @Autowired
    MongoTemplate mt;

    public void createSolicitud(Solicitud s){

        mt.insert(s);
    }

    public void createEspecialidad (Especialidad e){


        mt.insert(e);

    }

    public void createObraSocial (ObraSocial os){

        mt.insert(os);

    }

    public List<ObraSocial> getAllObrasSocial(){

       return mt.findAll(ObraSocial.class);
    }
    public List<Especialidad> getAllEspecialidad (){

        return mt.findAll(Especialidad.class);

    }


}
