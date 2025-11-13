package com.UH.OtherLevel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    private Long id;
    private String name;
    private String address;
    private Integer capacity;
    public Venue(Long id) {
        this.id = id;
    }
}
