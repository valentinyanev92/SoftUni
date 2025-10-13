package main.web.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import main.model.Item;
import main.model.PlayerClass;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestUploadRequest {

    @NotBlank
    @Size(min = 6, max = 26, message = "Title should be between [6-26] symbols!")
    private String title;

    @NotBlank
    private String itemId;

    @NotNull
    private PlayerClass playerClass;

    @NotBlank
    @Size(min = 110, max = 128, message = "Description should be between [110-128] symbols")
    private String description;

    @NotBlank
    @URL
    private String bannerUrl;

    @NotNull
    @Positive
    @Min(1)
    @Max(13)
    private Double xp;

}
