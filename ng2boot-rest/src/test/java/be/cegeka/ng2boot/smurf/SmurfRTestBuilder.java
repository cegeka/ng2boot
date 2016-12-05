package be.cegeka.ng2boot.smurf;

import java.time.LocalDate;

public class SmurfRTestBuilder {
    private long id;
    private String name;
    private LocalDate creationDate;

    private SmurfRTestBuilder() {
    }

    public static SmurfRTestBuilder aSmurfR() {
        return new SmurfRTestBuilder();
    }

    public SmurfR build() {
        return new SmurfR(id, name, creationDate);
    }

    public SmurfRTestBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public SmurfRTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SmurfRTestBuilder withCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}