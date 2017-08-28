package com.vptmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @Column(name = "id_module")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModule;

    @Column(name = "count_port_module")
    private int countPortModule;

    @Column(name = "count_empty_port_module")
    private  int countEmptyPortModule;

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getCountPortModule() {
        return countPortModule;
    }

    public void setCountPortModule(int countPortModule) {
        this.countPortModule = countPortModule;
    }

    public int getCountEmptyPortModule() {
        return countEmptyPortModule;
    }

    public void setCountEmptyPortModule(int countEmptyPortModule) {
        this.countEmptyPortModule = countEmptyPortModule;
    }

    @Override
    public String toString() {
        return "Module{" +
                "idModule=" + idModule +
                ", countPortModule=" + countPortModule +
                ", countEmptyPortModule=" + countEmptyPortModule +
                '}';
    }
}
