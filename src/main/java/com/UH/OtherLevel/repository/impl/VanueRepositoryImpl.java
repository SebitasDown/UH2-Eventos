package com.UH.OtherLevel.repository.impl;

import com.UH.OtherLevel.model.Venue;
import com.UH.OtherLevel.repository.interfaces.VenueRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VanueRepositoryImpl implements VenueRepository {
    private final List<Venue> venues = new ArrayList<>();
    private Long idContador = 1L;


    @Override
    public List<Venue> findAll() {
        return new ArrayList<>(venues);
    }

    @Override
    public Optional<Venue> findById(Long id) {
        return venues.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    @Override
    public Venue save(Venue venue) {
        if (venue.getId() == null){
            venue.setId(idContador++);
            venues.add(venue);
        }
        else {
            venues.stream()
                    .filter(v -> v.getId().equals(venue.getId()))
                    .findFirst()
                    .ifPresent(exist -> {
                        exist.setName(venue.getName());
                        exist.setAddress(venue.getAddress());
                        exist.setCapacity(venue.getCapacity());
                    });
        }
        return venue;
    }

    @Override
    public boolean deleteById(Long id) {
        return venues.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
