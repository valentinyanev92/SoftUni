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

    @Size(min = 2, max = 20, message = "First name should be between 2 and 20 symbols")
    String firstName;

    @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 symbols")
    String lastName;

    @Email(message = "Email should be email")
    String email;

    @URL(message = "Image link should be URL")
    String imageUrl;
}
