package main.web.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    @Size(min = 6, max = 12, message = "Username should be between [6-12] symbols long")
    private String username;

    @NotBlank
    @Digits(message = "Password should contain only digits!", integer = 6, fraction = 0)
    @Size(min = 6, max = 6, message = "Password should be exactly 6 digits!")
    private String password;
}
