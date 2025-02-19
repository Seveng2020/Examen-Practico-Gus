package com.examenpractico.backend.controller;

import com.examenpractico.backend.model.Resp;
import com.examenpractico.backend.model.Solicitud;
import com.examenpractico.backend.service.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/solicitud")
@RestController
public class SolicitudController {
    @Autowired
    TurnosService ts;
  @PostMapping("/create")
  public ResponseEntity<Resp> createSolicitud(@RequestBody Solicitud s) {

      if (s == null) {
          return ResponseEntity.badRequest().body(new Resp(false, "Ingresar Solicitud"));
      } else if(s.getNombre() == null || s.getNombre().isEmpty() || s.getNombre().isBlank()){ {
          return ResponseEntity.badRequest().body(new Resp(false, "Ingresar Nombre de Solicitud"));
      }
      }else if (s.getDni() == null || s.getDni().isEmpty() || s.getDni().isBlank()) {
          return ResponseEntity.badRequest().body(new Resp(false, "Ingresar DNI de Solicitud"));
      }else if (s.getIdEspecialidad() == null || s.getIdEspecialidad().isEmpty() || s.getIdEspecialidad().isBlank()) {
          return ResponseEntity.badRequest().body(new Resp(false, "Ingresar Especialidad de Solicitud"));
      }else if (s.getIdObraSocial() == null || s.getIdObraSocial().isEmpty() || s.getIdObraSocial().isBlank()) {
          return ResponseEntity.badRequest().body(new Resp(false, "Ingresar Obra Social de Solicitud"));
      }else if (s.getEmail() == null || s.getEmail().isEmpty() || s.getEmail().isBlank()) {
          return ResponseEntity.badRequest().body(new Resp(false, "Ingresar Mail de Solicitud"));
      }
      else{
          ts.createSolicitud(s);
          return new ResponseEntity<>(new Resp(true, "Solicitud Creada"), HttpStatusCode.valueOf(201));
      }
  }


}
