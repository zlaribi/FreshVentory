package de.iav.backend.security;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public record AppUser(
        String id,
        @Indexed(unique = true)
        String username,
        @Indexed(unique = true)
        String email,
        String password,
        AppUserRole role
) {
}
