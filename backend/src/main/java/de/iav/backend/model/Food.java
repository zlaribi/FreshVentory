package de.iav.backend.model;


import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

public record Food(
        @Id
        String foodId,
        String name,
        String quantity,
        List<String> category,
        //LocalDate in JSON "YYYY-MM-DD"
        LocalDate expirationDate

) {
}
