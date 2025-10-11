package app.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditProfileRequest {

    @Size(max = 24, message = "Fist name should be less than 24 symbols")
    String firstName;

    @Size(max = 24, message = "Last name should be less than 24 symbols")
    String lastName;

    @Email(message = "Email should be email")
    String email;

    @URL(message = "Image link should be URL")
    String imageUrl;
}
