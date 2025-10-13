package main.model;

import jakarta.persistence.*;
import lombok.*;
import main.web.dto.QuestRequest;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private PlayerRole role;

    @Enumerated(EnumType.STRING)
    private PlayerClass playerClass;

    private Double xp;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    public int getLevel() {

        return (int) (this.getXp() / 10) + 1;
    }

    public double getProgress() {

        return Math.max(1, ((this.getXp() % 10) / 10.0) * 100);
    }

}

