package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Size(min = 1, max = 12, message = "Username should be between [1-12] symbols")
    private String username;

    @NotBlank
    @Size(min = 1, max = 12, message = "Password should be between [1-12] symbols")
    private String password;

    @NotBlank
    @Size(min = 1, max = 12, message = "Nickname should be between [1-12] symbols")
    private String nickname;
}
