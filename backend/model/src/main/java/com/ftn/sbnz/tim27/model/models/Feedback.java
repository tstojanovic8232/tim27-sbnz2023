package com.ftn.sbnz.tim27.model.models;

public class Feedback {
    private Boolean pozitivan;
    private Boolean zaZanr;
    private String tip;
    private Long mediaId;

    public Feedback() {
    }

    public Feedback(Boolean pozitivan, Boolean zaZanr, String tip, Long mediaId) {
        this.pozitivan = pozitivan;
        this.zaZanr = zaZanr;
        this.tip = tip;
        this.mediaId = mediaId;
    }

    public Boolean getPozitivan() {
        return pozitivan;
    }

    public void setPozitivan(Boolean pozitivan) {
        this.pozitivan = pozitivan;
    }

    public Boolean getZaZanr() {
        return zaZanr;
    }

    public void setZaZanr(Boolean zaZanr) {
        this.zaZanr = zaZanr;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "pozitivan=" + pozitivan +
                ", zaZanr=" + zaZanr +
                ", tip='" + tip + '\'' +
                ", mediaId=" + mediaId +
                '}';
    }
}
