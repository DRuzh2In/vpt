package com.vptmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "network")
public class Network {

    @Id
    @Column(name = "id_network")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNetwork;

    @Column(name = "name_network")
    private String nameNetwork;

    @Column(name = "city_network")
    private String cityNetwork;

    public int getIdNetwork() {
        return idNetwork;
    }

    public void setIdNetwork(int id_network) {
        this.idNetwork = id_network;
    }

    public String getNameNetwork() {
        return nameNetwork;
    }

    public void setNameNetwork(String nameNetwork) {
        this.nameNetwork = nameNetwork;
    }

    public String getCityNetwork() {
        return cityNetwork;
    }

    public void setCityNetwork(String cityNetwork) {
        this.cityNetwork = cityNetwork;
    }

    @Override
    public String toString() {
        return "Network{" +
                "idNetwork=" + idNetwork +
                ", nameNetwork='" + nameNetwork + '\'' +
                ", cityNetwork='" + cityNetwork + '\'' +
                '}';
    }
}
