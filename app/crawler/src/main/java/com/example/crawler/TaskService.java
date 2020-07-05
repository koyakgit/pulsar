package com.example.crawler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TaskService {
    @Scheduled(fixedDelay = 1000)
    public void exec() {
        log.info("start: " + new Date().toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("end:   " + new Date().toString());
    }
}
