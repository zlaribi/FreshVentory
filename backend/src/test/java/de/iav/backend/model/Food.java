package de.iav.backend.model;

import java.util.List;

public record Food(
        String foodId,
        String name,
        String quantity,
        List<String> category,
        String expirationDate

) {
}
