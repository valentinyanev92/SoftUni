package main.web.dto;

import lombok.*;
import main.model.PlayerRole;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {

    private PlayerRole role;
}
