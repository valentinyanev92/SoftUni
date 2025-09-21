package app.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank
        @Size(min = 6, max = 24)
        String username,
        @NotBlank
        @Size(min = 6, max = 6)
        String password
) {
}
