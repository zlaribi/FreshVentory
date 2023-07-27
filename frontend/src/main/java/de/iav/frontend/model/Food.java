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
    public String getName() {
        return this.name;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getCategory() {
        return this.category;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }
}
