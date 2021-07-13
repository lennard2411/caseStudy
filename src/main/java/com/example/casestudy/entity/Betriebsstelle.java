package com.example.casestudy.entity;

public class Betriebsstelle {
    private String name;
    private String kurzname;
    private String typ;

    public Betriebsstelle(String name, String kurzname, String typ) {
        this.name = name;
        this.kurzname = kurzname;
        this.typ = typ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKurzname() {
        return kurzname;
    }

    public void setKurzname(String kurzname) {
        this.kurzname = kurzname;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
