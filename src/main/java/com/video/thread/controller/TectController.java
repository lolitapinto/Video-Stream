package com.video.thread.controller;

import com.video.thread.service.StreamProcessor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
public class TectController {


        @Autowired
        private StreamProcessor processor;

        @RequestMapping("/hello")
        public Map<String, String> callAsyncMethod(@RequestParam String url) {

            log.info("processing rtmp url : {}",url);
            processor.processStream(url);

            return new HashMap<String, String>();  // returns empty braces
        }
}
