package com.demo.services.report.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReportDto {

    @NotBlank
    private String text;
}
