package task1;

import java.util.concurrent.*;

public class Application {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Md5Hash md5Hash = new Md5Hash();

        Runnable hash1 = () -> {
            md5Hash.calculateMd5Hash();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable hash2 = () -> {
            md5Hash.calculateMd5Hash();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable hash3 = () -> {
            md5Hash.calculateMd5Hash();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        executor.submit(hash1);
        executor.submit(hash2);
        executor.submit(hash3);

        executor.shutdown();
    }

}