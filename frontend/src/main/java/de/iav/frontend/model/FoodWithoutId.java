package de.iav.frontend.model;

import java.time.LocalDate;

public record FoodWithoutId(
        String name,
        String quantity,
        String category,
        //LocalDate in JSON "YYYY-MM-DD"
        LocalDate expirationDate
) {
}
