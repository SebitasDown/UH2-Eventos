package com.UH.OtherLevel.mapper;

import com.UH.OtherLevel.dto.EventDTO;
import com.UH.OtherLevel.model.Event;
import com.UH.OtherLevel.model.Venue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "venueId", source = "venue.id")
    EventDTO toDTO (Event event);

    @Mapping(target = "venue", expression = "java(mapVenue(eventDTO))")
    Event toModel(EventDTO eventDTO);

    default Venue mapVenue(EventDTO eventDTO){
        if (eventDTO == null || eventDTO.getVenueId()== null) return null;
        Venue v = new Venue();
        v.setId(eventDTO.getVenueId());
        return v;
    }

}
