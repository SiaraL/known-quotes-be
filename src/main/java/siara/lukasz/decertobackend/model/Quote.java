package siara.lukasz.decertobackend.model;

import java.util.concurrent.atomic.AtomicLong;

public class Quote extends Entity{

    private static AtomicLong simulateAutoincrementId = new AtomicLong(0);
    private String value;
    private Author author;

    public Quote(){
        this.setId(simulateAutoincrementId.incrementAndGet());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
