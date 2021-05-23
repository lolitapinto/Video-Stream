package com.video.stream.opencv;


import lombok.extern.log4j.Log4j2;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StreamProcessor {

    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }


    public void readVideoStream(String rtmpUrl) {
//        VideoCapture cap = new VideoCapture("testvideo.mp4");
//
        VideoCapture cap = new VideoCapture(rtmpUrl);

        cap.open(0);
        while (cap.isOpened()) {

            Mat frame = new Mat();
            boolean read = cap.read(frame);

            if(read) {

                double width = cap.get(Videoio.CAP_PROP_FRAME_WIDTH);
                double msec = cap.get(Videoio.CAP_PROP_POS_MSEC);
                double framePos = cap.get(Videoio.CAP_PROP_POS_FRAMES);
                double fps = cap.get(Videoio.CAP_PROP_FPS);
                double  format = cap.get(Videoio.CAP_PROP_FORMAT);

                log.info("frame Width is {}" ,width);
                log.info("frame msec is {}" ,msec);
                log.info("frame framePos is {}" ,msec);
                log.info("frame fps is {}" ,msec);
                log.info("frame format is {}" ,msec);

            }

        }


    }




}
