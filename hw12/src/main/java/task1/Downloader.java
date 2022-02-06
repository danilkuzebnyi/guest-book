package task1;

import java.io.*;
import java.net.URL;
import java.util.List;

public class Downloader {

    public void downloadImages(List<String> linksOf200BestPhotos, int start, int end) throws IOException {
        for (int i = start; i < end; i++) {
            String link = linksOf200BestPhotos.get(i);
            URL url = new URL(link);
            int imageNumber = i + 1;
            String fileName = "hw12/src/main/resources/images/" + imageNumber + ".jpg";
            try (InputStream in = new BufferedInputStream(url.openStream());
                 FileOutputStream fos = new FileOutputStream(fileName);
                 OutputStream out = new BufferedOutputStream(fos)) {
                for (int j; (j = in.read()) != -1;) {
                    out.write(j);
                }
            }
        }
    }
}
