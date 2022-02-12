package com.company;

import java.time.LocalDate;

public class Owner {
    private String vorName;
    private String nachName;
    private LocalDate geburtstag;
    private Long kundenNr;
    private int alter;

    public Owner(String vorName, String nachName, LocalDate geburtstag, Long kundenNr) {
        this.vorName = vorName;
        this.nachName = nachName;
        this.geburtstag = geburtstag;
        this.kundenNr = kundenNr;
        this.alter = geburtstag.compareTo(LocalDate.now());
    }

    public Owner() {
    }

    public String getFullName(){
        String fullName = this.vorName + " " + this.nachName;
        return fullName;
    }

    public Long getKundenNr() {
        return kundenNr;
    }

    public void setKundenNr(Long kundenNr) {
        this.kundenNr = kundenNr;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        this.geburtstag = geburtstag;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "vorName='" + vorName + '\'' +
                ", nachName='" + nachName + '\'' +
                ", geburtstag=" + geburtstag +
                ", kundenNr=" + kundenNr +
                ", alter=" + alter +
                '}';
    }
}
