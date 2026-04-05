package com.sustainedu.backend.controller;

import com.sustainedu.backend.entity.Log;
import com.sustainedu.backend.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.createLog(log);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllLogs() {
        logService.deleteAllLogs();
        return ResponseEntity.ok("All logs cleared");
    }
}
