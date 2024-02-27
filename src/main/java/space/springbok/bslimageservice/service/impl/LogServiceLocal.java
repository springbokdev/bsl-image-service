package space.springbok.bslimageservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import space.springbok.bslimageservice.service.LogService;

@Service
@Slf4j
@Profile("local")
public class LogServiceLocal implements LogService {


    @Override
    public void log(String logLevel, String logEntry) {
        if (logLevel.equals("info")) {
            log.info(logEntry);
        } else if (logLevel.equals("warning")) {
            log.warn(logEntry);
        } else if (logLevel.equals("error")) {
            log.error(logEntry);
        }
    }
}
