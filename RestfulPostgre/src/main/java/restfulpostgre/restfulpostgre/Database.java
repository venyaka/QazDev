package restfulpostgre.restfulpostgre;

//import javax.persistence*;

//import javax.persistence.Column;
//import javax.persistence.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="rest_table")
public class Database {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="salam")
    private String salam;

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
