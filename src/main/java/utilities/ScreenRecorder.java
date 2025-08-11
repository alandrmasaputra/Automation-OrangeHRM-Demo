package utilities;

import java.io.*;

public class ScreenRecorder {
    private Process process;
    private String absolutePath;
    private String relativePath;
    private BufferedWriter ffmpegInput;

    public void startRecording(String testName) throws IOException {
        // Path relative untuk Extent Report
        relativePath = "recordings/" + testName + ".mp4";

        // Path absolute untuk ffmpeg
        String baseDir = new File("target/extent-reports/recordings").getAbsolutePath();
        new File(baseDir).mkdirs();
        absolutePath = baseDir + File.separator + testName + ".mp4";

        // Command ffmpeg
        String[] command = {
                "ffmpeg",
                "-y",
                "-hide_banner",             // hilangkan banner
                "-loglevel", "quiet",       // tidak ada log sama sekali
                "-f", "gdigrab",            // windows screen capture
                //"-f", "avfoundation",     // Mac screen capture
                "-framerate", "15",
                "-i", "desktop",
                "-vcodec", "libx264",
                "-preset", "ultrafast",
                "-pix_fmt", "yuv420p",
                absolutePath
        };

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        process = builder.start();

        ffmpegInput = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
    }

    public String stopRecording() {
        try {
            if (ffmpegInput != null) {
                ffmpegInput.write("q\n");
                ffmpegInput.flush();
            }
            if (process != null) {
                process.waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relativePath;
    }


}
