package com.sustainedu.backend.service;

import com.sustainedu.backend.entity.Log;
import com.sustainedu.backend.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> getAllLogs() {
        return logRepository.findAllByOrderByIdDesc();
    }

    public Log createLog(Log log) {
        if(log.getTime() == null) {
            log.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a")));
        }
        return logRepository.save(log);
    }

    public void deleteAllLogs() {
        logRepository.deleteAll();
    }
}
