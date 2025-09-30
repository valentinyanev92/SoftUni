package app.web.dto;

import app.user.model.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest{
        @NotBlank
        @Size(min = 6, max = 24, message = "Username length must be between 6 and 24 symbols.")
        private String username;

        @NotBlank
        @Size(min = 6, max = 6, message = "Password must be exactly 6 symbols.")
        private String password;

        @NotNull
        private Country country;

}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class RegisterRequest {
//
//    @NotBlank
//    @Size(min = 6, max = 24, message = "Username length must be between 6 and 24 symbols.")
//    private String username;
//
//    @NotBlank
//    @Size(min = 6, max = 6, message = "Password must be exactly 6 symbols.")
//    private String password;
//
//    @NotNull
//    private Country country;
//}
