package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Size(min = 4, max = 16, message = "Invalid username")
    private String username;

    @NotBlank
    @Size(min = 4, max = 16,message = "Invalid password")
    private String password;

    @NotBlank
    @Size(min = 4, max = 16, message = "Invalid nickname")
    private String nickname;
}
