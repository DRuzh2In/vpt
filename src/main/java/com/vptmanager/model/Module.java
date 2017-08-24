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
    private int count_port_module;

    @Column(name = "count_empty_port_module")
    private  int count_empty_port_module;

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getCount_port_module() {
        return count_port_module;
    }

    public void setCount_port_module(int count_port_module) {
        this.count_port_module = count_port_module;
    }

    public int getCount_empty_port_module() {
        return count_empty_port_module;
    }

    public void setCount_empty_port_module(int count_empty_port_module) {
        this.count_empty_port_module = count_empty_port_module;
    }

    @Override
    public String toString() {
        return "Module{" +
                "idModule=" + idModule +
                ", count_port_module=" + count_port_module +
                ", count_empty_port_module=" + count_empty_port_module +
                '}';
    }
}
