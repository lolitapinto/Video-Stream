package com.video.stream.ffmpeg;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class EncoderService {


    public boolean streamVideoToRTMP(String src, String dst) {

        String command = "ffmpeg  -re -y -i " + src + " -vcodec libx264 -vf fps=30 -b:a 128k -pix_fmt yuv420p -f flv -flvflags no_duration_filesize " +  dst;

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
