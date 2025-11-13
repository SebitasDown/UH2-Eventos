package com.UH.OtherLevel.service.impl;

import com.UH.OtherLevel.model.Event;
import com.UH.OtherLevel.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public Event create(Event event) {
        event.getName();
        return event;
    }

    @Override
    public Event update(Event event) {
        return null;
    }

    @Override
    public List<Event> getEventAll() {
        return List.of();
    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
