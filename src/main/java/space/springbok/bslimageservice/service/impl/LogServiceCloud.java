package space.springbok.bslimageservice.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import space.springbok.bslimageservice.service.LogService;

@Service
@Profile("dev")
public class LogServiceCloud implements LogService {


    @Override
    public void log(String logLevel, String logEntry) {
        // For cloud environment
    }
}
