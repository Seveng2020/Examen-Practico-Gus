package com.examenpractico.backend.controller;

import com.examenpractico.backend.model.ObraSocial;
import com.examenpractico.backend.model.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examenpractico.backend.service.TurnosService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@CrossOrigin("*")
@RequestMapping("/ooss")
@RestController
public class ObraSocialController {
    @Autowired
    TurnosService ts;

    @PostMapping("/create")
    public ResponseEntity<Resp> createObraSocial(@RequestBody ObraSocial os){

        if (os == null) {
             return ResponseEntity.ok().body(new Resp(false, "Ingresar Nombre de OS"));
         }else if (os.getNombre() == null || os.getNombre().isEmpty() || os.getNombre().isBlank()) {
             return ResponseEntity.ok().body(new Resp(false, "Ingresar Nombre de OS"));
         }
         else {
             ts.createObraSocial(os);
             return new ResponseEntity<>(new Resp(true, "Obra Social Creada"), HttpStatus.CREATED);
         }


    }
    @GetMapping("/all")
    public ResponseEntity<List> getAllObrasSocial(){


        return ResponseEntity.ok().body(ts.getAllObrasSocial());

    }


}
