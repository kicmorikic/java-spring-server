package com.SpringCourse.server.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Prognoza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String region;
    private int temperatura; // -270:6051
    private int szansaNaDeszczProcent; //0:100
    private int zachmurzenieProcent;//0:100
    private LocalDateTime creationDate;
    protected Prognoza(){};

    @PrePersist
    protected void prePersist(){
        this.creationDate = LocalDateTime.now();
    }

    public Prognoza(String region, int temperatura, int szansaNaDeszczProcent, int zachmurzenieProcent) {
        this.region = region;
        this.temperatura = temperatura;
        this.szansaNaDeszczProcent = szansaNaDeszczProcent;
        this.zachmurzenieProcent = zachmurzenieProcent;
    }

    public long getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getSzansaNaDeszczProcent() {
        return szansaNaDeszczProcent;
    }

    public int getZachmurzenieProcent() {
        return zachmurzenieProcent;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
