package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    @Size(min = 4, max = 16, message = "Username length should be between [4-16] symbols log")
    private String username;

    @NotBlank
    @Size(min = 4, max = 16, message = "Password length should be between [4-16] symbols log")
    private String password;
}
