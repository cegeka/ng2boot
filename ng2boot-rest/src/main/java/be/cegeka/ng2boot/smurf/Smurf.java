package be.cegeka.ng2boot.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;

@Entity
public class Smurf {

    /**
     * Default Constructor for hibernate
     */
    protected Smurf() {
    }

    @Id
    @Column(name = "ID")
    private long id;

    @Lob
    @Column(name = "MESSAGE", length = -1)
    private String name;

    @Column(name = "CREATIONDATE")
    private LocalDate creationDate;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public static class SmurfBuilder {

        private Smurf smurf;

        private SmurfBuilder() {
            smurf = new Smurf();
        }

        public static SmurfBuilder aSmurf() {
            return new SmurfBuilder();
        }

        public Smurf build() {
            return smurf;
        }

        public SmurfBuilder withName(String message) {
            smurf.name = message;
            return this;
        }

        public SmurfBuilder withCreationDate(LocalDate creationDate) {
            smurf.creationDate = creationDate;
            return this;
        }
    }
}
