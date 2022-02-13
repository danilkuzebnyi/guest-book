package task1;

public class GuestBook {
    private String name;
    private String message;
    private String rating;

    public GuestBook(String name, String message, String rating) {
        this.name = name;
        this.message = message;
        this.rating = rating;
    }

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + "        " + message + "        " + rating;
    }
}
