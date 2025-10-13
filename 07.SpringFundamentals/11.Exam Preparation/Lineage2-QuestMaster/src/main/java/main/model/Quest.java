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
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double xp;

    @Column(nullable = false, unique = true)
    private String bannerUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlayerClass eligibleClass;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item rewardItem;

    @ManyToOne
    private Player capturer;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String updatedBy;
}

