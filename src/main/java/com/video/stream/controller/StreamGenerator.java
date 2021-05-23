package com.video.stream.controller;

import com.video.stream.ffmpeg.EncoderService;
import com.video.stream.opencv.StreamProcessor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@Log4j2
public class StreamGenerator {

    @Autowired
    EncoderService encoderService;

    @Autowired
    StreamProcessor streamProcessor;

    @GetMapping("/rtmp")
    @ResponseBody
    public String getRtmpStream(@RequestParam String source, @RequestParam String stream) {

        log.info("Stream video : {}", source);
        log.info("Stream video to URL : {}", stream);

       boolean success =  encoderService.streamVideoToRTMP(source,stream);
       log.info("Video is streaming : {}", success);

       if(success) {
            return "SUCCESS";
       }

       return "FAILURE";
    }

    @GetMapping("/rtmp/read")
    @ResponseBody
    public void readStreams(@RequestParam String source) {

        log.info("Stream video : {}", source);

        streamProcessor.readVideoStream(source);
        log.info("Video Stream read:");

    }

}
