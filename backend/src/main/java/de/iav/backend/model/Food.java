package de.iav.backend.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Food(
        @Id
        String foodId,
        String name,
        String quantity,
        String category,
        //LocalDate in JSON "YYYY-MM-DD"
        LocalDate expirationDate
) {
}
