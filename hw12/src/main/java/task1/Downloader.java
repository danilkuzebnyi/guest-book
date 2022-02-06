package task1;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.List;

public class Downloader {

    public void downloadImages(List<String> links, int start, int end) throws IOException {
        for (int i = start; i < end; i++) {
            String link = links.get(i);
            URL url = new URL(link);
            int imageNumber = i + 1;
            String fileName = "hw12/src/main/resources/images/" + imageNumber + ".jpg";
            Path file = Files.createFile(Paths.get(fileName));
            Files.write(file, url.openStream().readAllBytes());
        }
    }
}
