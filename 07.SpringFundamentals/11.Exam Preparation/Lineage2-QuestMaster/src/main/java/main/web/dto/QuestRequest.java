package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestRequest {

    @NotBlank
    private String questId;
}

