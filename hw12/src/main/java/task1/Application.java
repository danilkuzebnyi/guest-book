package task1;

import java.io.*;
import java.util.List;
import java.util.concurrent.*;

public class Application {

    public static void main(String[] args) {
        Browser browser = new Browser();

        Downloader downloader = new Downloader();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Runnable downloader1 = () -> {
            long start1 = System.currentTimeMillis();
            try {
                List<String> links = browser.getLinksOf200BestPhotos();
                downloader.downloadImages(links, 0, 50);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            long end1 = System.currentTimeMillis();
            System.out.println("Time: " + (end1 - start1) + " ms");
        };

        Runnable downloader2 = () -> {
            long start2 = System.currentTimeMillis();
            try {
                List<String> links = browser.getLinksOf200BestPhotos();
                downloader.downloadImages(links, 50, 100);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            long end2 = System.currentTimeMillis();
            System.out.println("Time: " + (end2 - start2) + " ms");
        };

        Runnable downloader3 = () -> {
            long start3 = System.currentTimeMillis();
            try {
                List<String> links = browser.getLinksOf200BestPhotos();
                downloader.downloadImages(links, 100, 150);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            long end3 = System.currentTimeMillis();
            System.out.println("Time: " + (end3 - start3) + " ms");
        };

        Runnable downloader4 = () -> {
            long start4 = System.currentTimeMillis();
            try {
                List<String> links = browser.getLinksOf200BestPhotos();
                downloader.downloadImages(links, 150, 200);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            long end4 = System.currentTimeMillis();
            System.out.println("Time: " + (end4 - start4) + " ms");
        };

        executor.submit(downloader1);
        executor.submit(downloader2);
        executor.submit(downloader3);
        executor.submit(downloader4);

        executor.shutdown();
    }
}
