package com.UH.OtherLevel.service.impl;

import com.UH.OtherLevel.model.Event;
import com.UH.OtherLevel.model.Venue;
import com.UH.OtherLevel.repository.interfaces.EventRepository;
import com.UH.OtherLevel.repository.interfaces.VenueRepository;
import com.UH.OtherLevel.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    @Override
    public Event create(Event event) {


        if (event.getVenue() == null || event.getVenue().getId() == null) {
            throw new IllegalArgumentException("El ID del venue no puede ser null");
        }
        if (event.getName() == null || event.getName().isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        Long venueId = event.getVenue().getId();
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new IllegalArgumentException("Lugar no encontrado" + venueId));
        event.setVenue(venue);
        return eventRepository.save(event);
    }

    @Override
    public Event update(Event event) {;

        Event exist = eventRepository.findById(event.getId())
                .orElseThrow(()-> new IllegalArgumentException("Evento no encontrado"));

        Long venueId = event.getVenue().getId();
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new IllegalArgumentException("Lugar no encontrado"));

        exist.setName(event.getName());
        exist.setDate(event.getDate());
        exist.setVenue(venue);
        return eventRepository.update(exist);
    }

    @Override
    public List<Event> getEventAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));
    }

    @Override
    public boolean deleteById(Long id) {
        return eventRepository.deleteById(id);
    }
}
