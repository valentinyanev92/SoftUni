package main.web.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.House;
import main.model.WizardAlignment;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Size(min = 6, max = 12, message = "Username should be between [6-12] symbols long")
    private String username;
    
    @NotBlank
    @Digits(message = "Password should contain only digits!", integer = 6, fraction = 0)
    @Size(min = 6, max = 6, message = "Password should be exactly 6 digits!")
    private String password;

    @NotBlank
    @URL(message = "Avatar should be URL!")
    private String avatarUrl;

    @NotNull
    private House house;

    @NotNull
    private WizardAlignment alignment;
}
