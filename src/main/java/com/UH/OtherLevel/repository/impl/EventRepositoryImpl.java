package com.UH.OtherLevel.repository.impl;

import com.UH.OtherLevel.entities.EventEntity;
import com.UH.OtherLevel.mapper.EventEntityMapper;
import com.UH.OtherLevel.mapper.EventMapper;
import com.UH.OtherLevel.model.Event;
import com.UH.OtherLevel.repository.interfaces.EventRepository;
import com.UH.OtherLevel.repository.jpa.JpaEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {

    private final JpaEventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        List<EventEntity> entities = eventRepository.findAll();
        return EventEntityMapper.INSTANCE.toModelList(entities);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id)
                .map(EventEntityMapper.INSTANCE::toModel);
    }

    @Override
    public Event save(Event event) {
        EventEntity eventEntity = EventEntityMapper.INSTANCE.toEntity(event);
        EventEntity saved = eventRepository.save(eventEntity);
        return EventEntityMapper.INSTANCE.toModel(saved);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!eventRepository.existsById(id)){
            return false;
        }
        eventRepository.deleteById(id);
        return true;
    }

    @Override
    public Event update(Event event) {
        if (event.getId()== null){
            throw new IllegalArgumentException("NOT NULL");
        }
        Optional<EventEntity> existingEntity = eventRepository.findById(event.getId());
        if (existingEntity.isEmpty()) {
            return null;
        }

        EventEntity eventEntityUpdate = EventEntityMapper.INSTANCE.toEntity(event);

        EventEntity update = eventRepository.save(eventEntityUpdate);


        return EventEntityMapper.INSTANCE.toModel(update);
    }

}
