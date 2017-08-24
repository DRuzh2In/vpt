package com.vptmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "line")
public class Line {

    @Id
    @Column(name = "id_line")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLine;

    @Column(name = "direct_line")
    private String directLine;

    @Column(name = "count_port_line")
    private int countPortLine;

    @Column(name = "count_free_port_line")
    private int countFreePortLine;

    @Column(name = "len_line")
    private int lenLine;

    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public String getDirectLine() {
        return directLine;
    }

    public void setDirectLine(String directLine) {
        this.directLine = directLine;
    }

    public int getCountPortLine() {
        return countPortLine;
    }

    public void setCountPortLine(int countPortLine) {
        this.countPortLine = countPortLine;
    }

    public int getCountFreePortLine() {
        return countFreePortLine;
    }

    public void setCountFreePortLine(int countFreePortLine) {
        this.countFreePortLine = countFreePortLine;
    }

    public int getLenLine() {
        return lenLine;
    }

    public void setLenLine(int lenLine) {
        this.lenLine = lenLine;
    }

    @Override
    public String toString() {
        return "Line{" +
                "idLine=" + idLine +
                ", directLine='" + directLine + '\'' +
                ", countPortLine=" + countPortLine +
                ", countFreePortLine=" + countFreePortLine +
                ", lenLine=" + lenLine +
                '}';
    }
}
