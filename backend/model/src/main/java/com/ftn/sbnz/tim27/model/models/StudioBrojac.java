package com.ftn.sbnz.tim27.model.models;

public class StudioBrojac {
    private Studio studio;
    private int brojac;

    public StudioBrojac() {
    }

    public StudioBrojac(Studio studio) {
        this.studio = studio;
        this.brojac = 0;
    }

    public Studio getStudio() {
        return studio;
    }

    public int getBrojac() {
        return brojac;
    }

    public void povecajBrojac() {
        brojac++;
    }

    @Override
    public String toString() {
        return "StudioBrojac{" +
                "studio=" + studio +
                ", brojac=" + brojac +
                '}';
    }
}
