package com.UH.OtherLevel.service;

import com.UH.OtherLevel.model.Event;

import java.lang.management.LockInfo;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event create (Event event);
    Event update (Event event);
    List<Event> getEventAll ();
    Event findById (Long id);
    boolean deleteById (Long id);
}
