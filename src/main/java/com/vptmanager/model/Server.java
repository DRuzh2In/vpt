package com.vptmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "server")
public class Server {

    @Id
    @Column(name = "id_server")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServer;

    @Column(name = "name_server")
    private String nameServer;

    @Column(name = "address_server")
    private String addressServer;

    public int getIdServer() {
        return idServer;
    }

    public void setIdServer(int idServer) {
        this.idServer = idServer;
    }

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    public String getAddressServer() {
        return addressServer;
    }

    public void setAddressServer(String addressServer) {
        this.addressServer = addressServer;
    }

    @Override
    public String toString() {
        return "Server{" +
                "idServer=" + idServer +
                ", nameServer='" + nameServer + '\'' +
                ", addressServer='" + addressServer + '\'' +
                '}';
    }
}
