package siara.lukasz.decertobackend.model;

import java.util.concurrent.atomic.AtomicLong;

public class Author extends Entity{

    private static AtomicLong simulateAutoincrementId = new AtomicLong(0);
    private String firstName;
    private String lastName;

    public Author(){
        this.setId(simulateAutoincrementId.incrementAndGet());
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
