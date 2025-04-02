package com.demo.services.report.service;

import com.demo.services.report.dto.ReportDto;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public String report(ReportDto reportDto) {
        return "Crete report complete! ==> " + reportDto.getText();
    }
}
