package com.video.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RTMPStream {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        boolean b = streamVideoToRTMP("testvideo.mp4", "rtmp://10.111.137.201:1935/live/stream");
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to process : " + (endTime-startTime));
        File file = new File("testvideo.mp4");
        String path = file.getAbsolutePath();
        System.out.println("File path is : "+path);

        System.out.println("Succeeded : "+b);
    }

    public static boolean streamVideoToRTMP(String src, String dst) {

        String command = "ffmpeg  -re -y -i " + src + " -vcodec libx264 -b:a 128k -pix_fmt yuv420p -f flv -flvflags no_duration_filesize " +  dst;

        try {
            ProcessBuilder builder = new ProcessBuilder();

            /* for linux uncomment below */
            // builder.command("bash", "-c", command);

            /* for windows uncomment below */
            builder.command("cmd.exe", "/c", command);

            builder.redirectErrorStream(true);
            Process process = builder.start();
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("process done...");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
