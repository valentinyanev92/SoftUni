package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import main.model.ItemType;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @NotBlank
    @Size(min = 6, max = 26, message = "Name should be between [6-26] symbols!")
    private String name;

    @NotNull
    private ItemType type;

    @NotNull
    @Positive
    @Range(min = 1, max = 3)
    private Double xpBonusMultiplier;

    @NotNull
    @URL
    private String iconUrl;
}
