package task1;

import java.util.concurrent.*;

public class Application {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable hash1 = () -> {
            Encoder md5Hash1 = new Encoder();
            md5Hash1.calculateMd5Hash();
        };

        Runnable hash2 = () -> {
            Encoder md5Hash2 = new Encoder();
            md5Hash2.calculateMd5Hash();
        };

        Runnable hash3 = () -> {
            Encoder md5Hash3 = new Encoder();
            md5Hash3.calculateMd5Hash();
        };

        executor.submit(hash1);
        executor.submit(hash2);
        executor.submit(hash3);

        executor.shutdown();
    }
}