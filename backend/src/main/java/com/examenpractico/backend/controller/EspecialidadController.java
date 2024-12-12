package com.examenpractico.backend.controller;

import com.examenpractico.backend.model.Especialidad;
import com.examenpractico.backend.model.Resp;
import com.examenpractico.backend.service.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/especialidad")
@RestController
public class EspecialidadController {
    @Autowired
    TurnosService ts;

    @PostMapping("/create")
    public ResponseEntity<Resp> createEspecialidad(@RequestBody Especialidad e){
        if (e.getNombre() == null) {
            return ResponseEntity.badRequest().body(new Resp(false, "Ingresar Nombre de Especialidad"));
        } else {
            ts.createEspecialidad(e);
            return new ResponseEntity<>(new Resp(true, "Especialidad Creada"), HttpStatus.CREATED);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List> getAllEspecialidad(){
        return ResponseEntity.ok().body(ts.getAllEspecialidad());
    }



}
