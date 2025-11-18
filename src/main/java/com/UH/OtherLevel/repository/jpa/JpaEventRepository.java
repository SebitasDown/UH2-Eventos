package com.UH.OtherLevel.repository.jpa;


import com.UH.OtherLevel.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEventRepository extends JpaRepository<EventEntity, Long> {
}