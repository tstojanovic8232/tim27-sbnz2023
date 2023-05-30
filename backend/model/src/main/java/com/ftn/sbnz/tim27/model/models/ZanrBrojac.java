package com.ftn.sbnz.tim27.model.models;

public class ZanrBrojac {
    private Zanr zanr;
    private int brojac;

    public ZanrBrojac() {
    }

    public ZanrBrojac(Zanr zanr) {
        this.zanr = zanr;
        this.brojac = 0;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public int getBrojac() {
        return brojac;
    }

    public void povecajBrojac() {
        brojac++;
    }

    @Override
    public String toString() {
        return "ZanrBrojac{" +
                "zanr=" + zanr +
                ", brojac=" + brojac +
                '}';
    }
}
