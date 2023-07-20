package de.iav.backend.model;

import java.time.LocalDate;
import java.util.List;

public record FoodWithoutId(
        String name,
        String quantity,
        List<String> category,
        //LocalDate in JSON "YYYY-MM-DD"
        LocalDate expirationDate

) {
}
