package restfulpostgre.restfulpostgre;

//import javax.persistence*;

//import javax.persistence.Column;
//import javax.persistence.Entity;

import jakarta.persistence.*;
import java.util.Objects;

//@Table(name="rest_table")

@Entity(name="salams")
public class Database {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public String salam;

    public Database() {
    }

    public Database(String salam) {
        this.salam = salam;
    }

    @Override
    public String toString() {
        return "Database{" +
                "id=" + id +
                ", salam='" + salam + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSalam() {
        return salam;
    }

    public void setSalam(String salam) {
        this.salam = salam;
    }

}
