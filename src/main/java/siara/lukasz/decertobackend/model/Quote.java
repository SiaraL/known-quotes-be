package siara.lukasz.decertobackend.model;

public class Quote extends Entity{

    private String value;
    private Author author;

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
