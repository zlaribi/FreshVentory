package de.iav.frontend.model;

import java.time.LocalDate;

public record Food(
        String foodId,
        String name,
        String quantity,
        String category,
        //LocalDate in JSON "YYYY-MM-DD"
        LocalDate expirationDate
) {
}
