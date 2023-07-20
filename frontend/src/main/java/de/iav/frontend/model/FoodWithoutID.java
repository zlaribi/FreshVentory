package de.iav.frontend.model;

import java.time.LocalDate;
import java.util.List;

public record FoodWithoutID(
        String name,
        String quantity,
        List<String> category,
        //LocalDate in JSON "YYYY-MM-DD"
        LocalDate expirationDate
) {
}
