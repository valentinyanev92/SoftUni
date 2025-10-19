package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditProfileRequest {

    @NotBlank
    @Size(min = 6, max = 12, message = "Username should be between [6-12] symbols long")
    private String username;

    @NotBlank
    @URL(message = "Avatar should be URL!")
    private String avatarUrl;
}
