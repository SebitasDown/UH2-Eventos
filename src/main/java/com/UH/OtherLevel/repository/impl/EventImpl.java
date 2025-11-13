package com.UH.OtherLevel.repository.impl;

import com.UH.OtherLevel.model.Event;
import com.UH.OtherLevel.repository.interfaces.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EventImpl implements EventRepository {

    //Base de datos en memoria
    private List<Event> events;
    private Long IdContador = 1L;

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return events.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public Event save(Event event) {
        if (event.getId() == null){
            event.setId(IdContador++);
            events.add(event);
        }
        // Este de aqui actualiza si el id es igual
        else{
            events.stream()
                    .filter(e -> e.getId().equals(event.getId()))
                    .findFirst()
                    .ifPresent(existing ->{
                        existing.setName(event.getName());
                        existing.setDate(event.getDate());
                        existing.setVenue(event.getVenue());
                    });
        }
        return event;
    }

    @Override
    public void deleteById(Long id) {
        events.removeIf(e -> e.getId().equals(id));

    }

    @Override
    public boolean existById(Long id) {
        return events.stream().anyMatch(e -> e.getId().equals(id));
    }
}
