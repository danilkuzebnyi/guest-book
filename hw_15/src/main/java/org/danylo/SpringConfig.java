package org.danylo;

import org.danylo.guestbook.models.GuestBook;
import org.danylo.guestbook.repository.GuestBookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SpringBootApplication
public class SpringConfig {
    private static final int QTY_OF_BOOKS = 10;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringConfig.class, args);
        GuestBookRepository bookRepository =
                applicationContext.getBean("guestBookRepository", GuestBookRepository.class);
        List<GuestBook> books = bookRepository.getBooks();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            for (int i = 1; i <= QTY_OF_BOOKS; i++) {
            GuestBook book = applicationContext.getBean("guestBook", GuestBook.class);
            book.setName("book" + i);
            book.setMessage("book" + i + " is interesting");
            book.setRating(i % 5 + 1);
            books.add(book);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    executorService.shutdown();
                }
            }
        });
    }
}
