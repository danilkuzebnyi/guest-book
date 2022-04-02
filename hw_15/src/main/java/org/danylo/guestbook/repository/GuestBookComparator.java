package org.danylo.guestbook.repository;

import org.danylo.guestbook.models.GuestBook;
import java.util.Comparator;

public class GuestBookComparator implements Comparator<GuestBook> {

    @Override
    public int compare(GuestBook book1, GuestBook book2) {
         return book2.getDateTime().compareTo(book1.getDateTime());
    }
}
