package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mob {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private Integer level;

    private Double health;

    private Double attack;

    private Double defence;

    private Boolean alive;

    private Integer adenaDrop;

    private Integer xpDrop;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MobType mobType;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String spawnArea;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;
}

