package com.UH.OtherLevel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime date;

    @NotNull(message = "Lugar obligatorio")
    private Long venueId;

}
