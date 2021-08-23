package siara.lukasz.decertobackend.dto;

import siara.lukasz.decertobackend.model.Author;

public class AuthorDto extends Dto{

    private String firstName;
    private String lastName;

    public AuthorDto(Author author){
        this.setId(author.getId());
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
    }

    public AuthorDto(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
