package com.vptmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "cross")
public class Cross {

    @Id
    @Column(name = "id_cross")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCross;

    @Column(name = "name_cross")
    private String nameCross;

    @Column(name = "data_change")
    private String dateChange;

    @Column(name = "tc_name")
    private String tcName;

    @Column(name = "free_mode")
    private int freeMod;

    @Column(name = "count_mode")
    private int countMod;

    public int getIdCross() {
        return idCross;
    }

    public void setIdCross(int idCross) {
        this.idCross = idCross;
    }

    public String getNameCross() {
        return nameCross;
    }

    public void setNameCross(String nameCross) {
        this.nameCross = nameCross;
    }

    public String getDateChange() {
        return dateChange;
    }

    public void setDateChange(String dateChange) {
        this.dateChange = dateChange;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public int getFreeMod() {
        return freeMod;
    }

    public void setFreeMod(int freeMod) {
        this.freeMod = freeMod;
    }

    public int getCountMod() {
        return countMod;
    }

    public void setCountMod(int countMod) {
        this.countMod = countMod;
    }

    @Override
    public String toString() {
        return "Cross{" +
                "idCross=" + idCross +
                ", nameCross='" + nameCross + '\'' +
                ", dateChange='" + dateChange + '\'' +
                ", tcName='" + tcName + '\'' +
                ", freeMod=" + freeMod +
                ", countMod=" + countMod +
                '}';
    }
}
