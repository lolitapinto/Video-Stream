package com.video.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VideoStreamThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoStreamThreadApplication.class, args);
	}

}
