package com.vptmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "port")
public class Port {

    @Id
    @Column(name = "id_port")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPort;

    @Column(name = "num_port")
    private int numPort;

    @Column(name = "empty_port")
    private boolean emptyPort;

    @Column(name = "id_next_port")
    private int idNextPort;

    @Column(name = "id_prev_port")
    private int idPrevPort;

    @Column(name = "connect")
    private String connect;

    @Column(name = "service")
    private String service;

    @Column(name = "type_port")
    private String typePort;

    @Column(name = "comment")
    private String comment;

    public int getIdPort() {
        return idPort;
    }

    public void setIdPort(int idPort) {
        this.idPort = idPort;
    }

    public int getNumPort() {
        return numPort;
    }

    public void setNumPort(int numPort) {
        this.numPort = numPort;
    }

    public boolean isEmptyPort() {
        return emptyPort;
    }

    public void setEmptyPort(boolean emptyPort) {
        this.emptyPort = emptyPort;
    }

    public int getIdNextPort() {
        return idNextPort;
    }

    public void setIdNextPort(int idNextPort) {
        this.idNextPort = idNextPort;
    }

    public int getIdPrevPort() {
        return idPrevPort;
    }

    public void setIdPrevPort(int idPrevPort) {
        this.idPrevPort = idPrevPort;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getServise() {
        return service;
    }

    public void setServise(String servise) {
        this.service = servise;
    }

    public String getTypePort() {
        return typePort;
    }

    public void setTypePort(String typePort) {
        this.typePort = typePort;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Port{" +
                "idPort=" + idPort +
                ", numPort=" + numPort +
                ", emptyPort=" + emptyPort +
                ", idNextPort=" + idNextPort +
                ", idPrevPort=" + idPrevPort +
                ", connect='" + connect + '\'' +
                ", servise='" + service + '\'' +
                ", typePort='" + typePort + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
