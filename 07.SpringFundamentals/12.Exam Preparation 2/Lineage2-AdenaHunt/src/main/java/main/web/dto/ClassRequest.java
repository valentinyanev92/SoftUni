package main.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.PlayerClass;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {

    private PlayerClass playerClass;
}
