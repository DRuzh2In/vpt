package com.vptmanager.model;

// connect with data base
import javax.persistence.*;

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @Column(name = "id_zone")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZone;

    @Column(name = "name_zone")
    private String nameZone;

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int id_zone) {
        this.idZone = id_zone;
    }

    public String getNameZone() {
        return nameZone;
    }

    public void setNameZone(String nameZone) {
        this.nameZone = nameZone;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "idZone=" + idZone +
                ", nameZone='" + nameZone + '\'' +
                '}';
    }
}
