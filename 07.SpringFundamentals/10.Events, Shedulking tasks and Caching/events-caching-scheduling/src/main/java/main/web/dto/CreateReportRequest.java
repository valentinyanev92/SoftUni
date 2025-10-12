package main.web.dto;

import lombok.Data;

@Data
public class CreateReportRequest {

    private String agent;

    private String description;
}
