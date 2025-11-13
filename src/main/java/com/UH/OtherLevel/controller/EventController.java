package com.UH.OtherLevel.controller;

import com.UH.OtherLevel.dto.EventDTO;
import com.UH.OtherLevel.mapper.EventMapper;
import com.UH.OtherLevel.model.Event;
import com.UH.OtherLevel.service.EventService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventDTO> crearEvento (@RequestBody EventDTO eventDTO){
        Event event = eventService.create(EventMapper.INSTANCE.toModel(eventDTO));
        // Mejor practica crear un DTO de respuesta Uno para la peticion y la respuesta
        EventDTO eventCreate = EventMapper.INSTANCE.toDTO(event);

        EventDTO eventCreated2 = EventMapper.INSTANCE.
                toDTO(eventService.
                        create(EventMapper.INSTANCE.toModel(eventDTO)));

        return ResponseEntity.ok(eventCreate);
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosEventos (){
        return null;
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<?> obtenerPorId (){
        return null;
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<?> editarEvento (){
        return null;
    }
    @DeleteMapping("/events/{id}")
    public ResponseEntity<?> eliminarEvento (){
        return null;
    }
}
