package main.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Report {

    private String agent;

    private String message;

    private LocalDateTime createdOn;
}
