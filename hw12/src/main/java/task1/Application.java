package task1;

import java.io.*;
import java.util.List;
import java.util.concurrent.*;

public class Application {
    private static final int QTY_OF_PHOTOS = 200;
    private static final int NUMBER_OF_THREADS = 4;
    private static final int qtyOfPhotosByThread = QTY_OF_PHOTOS / NUMBER_OF_THREADS;
    private static Browser browser = new Browser();
    private static Downloader downloader = new Downloader();
    private static ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void main(String[] args) {
        for (int i = 0; i < QTY_OF_PHOTOS; i = i + qtyOfPhotosByThread) {
            createThread(i);
        }
        executor.shutdown();
    }

    private static void createThread(int i) {
        Runnable runnable = () -> {
            long start = System.currentTimeMillis();
            try {
                List<String> links = browser.getLinksOfBestPhotos(QTY_OF_PHOTOS);
                downloader.downloadImages(links, i, i + QTY_OF_PHOTOS / NUMBER_OF_THREADS);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time: " + (end - start) + " ms");
        };
        executor.submit(runnable);
    }
}
