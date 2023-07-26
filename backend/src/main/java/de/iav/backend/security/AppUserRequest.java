package de.iav.backend.security;

public record AppUserRequest(
        String username,
        String email,
        String password
) {
}
