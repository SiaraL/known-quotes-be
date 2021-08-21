package siara.lukasz.decertobackend.dto;

import siara.lukasz.decertobackend.model.Quote;

public class QuoteDto extends Dto{

    private String value;
    private AuthorDto author;

    public QuoteDto(Quote quote){
        this.setId(quote.getId());
        this.value = quote.getValue();
        this.author = new AuthorDto(quote.getAuthor());
    }

    public QuoteDto(){}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
