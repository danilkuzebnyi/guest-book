package org.danylo.guestbook.repository;

import org.danylo.guestbook.models.GuestBook;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class GuestBookRepository {
    private List<GuestBook> books = new CopyOnWriteArrayList<>();

    public List<GuestBook> getBooks() {
        return books;
    }
}
