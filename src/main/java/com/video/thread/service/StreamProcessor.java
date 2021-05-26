package com.video.thread.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StreamProcessor {

        @Async
        public void processStream(String url) {
            try {
                Thread.sleep(3000);	// Let me sleep for 3 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("My Name " + Thread.currentThread().getName());
        }
}
