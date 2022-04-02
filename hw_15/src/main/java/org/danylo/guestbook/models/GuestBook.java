package org.danylo.guestbook.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class GuestBook {
    private String name;
    private String message;
    private int rating;
    private LocalDateTime dateTime = LocalDateTime.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
