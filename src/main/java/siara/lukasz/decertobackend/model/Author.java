package siara.lukasz.decertobackend.model;

public class Author extends Entity{

    private static long simulateAutoincrementId = 1;
    private String firstName;
    private String lastName;

    public Author(){
        this.setId(simulateAutoincrementId++);
    }

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
