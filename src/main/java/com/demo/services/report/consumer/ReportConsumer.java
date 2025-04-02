package com.demo.services.report.consumer;

import com.demo.services.report.dto.ReportDto;
import com.demo.services.report.exception.CustomException;
import com.demo.services.report.service.ReportService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReportConsumer {

    private static final Logger log = LoggerFactory.getLogger(ReportConsumer.class);
    private final ReportService reportService;

    @RabbitListener(queues = "report.queue")
    public void listen(@Payload ReportDto reportDto) throws CustomException {
        String result = reportService.report(reportDto);
        log.info(result);
        throw new CustomException();
    }
}
