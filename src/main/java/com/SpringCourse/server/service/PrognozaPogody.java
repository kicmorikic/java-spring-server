package com.SpringCourse.server.service;

import java.util.concurrent.ThreadLocalRandom;

public class PrognozaPogody implements Comparable {

    private String region;
    private int temperatura; // -270:6051
    private int szansaNaDeszczProcent; //0:100
    private int zachmurzenieProcent;//0:100
    public PrognozaPogody(int temperatura, int szansaNaDeszczProcent, int zachmurzenieProcent){
        this.region="";
        //TEMPERATURA
        if(temperatura < -270)
        {
            this.temperatura = -270;
        }
        else if(temperatura > 6051)
        {
            this.temperatura = 6051;
        }
        else
        {
            this.temperatura = temperatura;
        }
        //DESZCZ
        if(szansaNaDeszczProcent < 0)
        {
            this.szansaNaDeszczProcent = 0;
        }
        else if(szansaNaDeszczProcent > 100)
        {
            this.szansaNaDeszczProcent =100;
        }
        else
        {
            this.szansaNaDeszczProcent = szansaNaDeszczProcent;
        }
        //CHMURY
        if(zachmurzenieProcent < 0)
        {
            this.zachmurzenieProcent = 0;
        }
        else if(zachmurzenieProcent > 100)
        {
            this.zachmurzenieProcent =100;
        }
        else
        {
            this.zachmurzenieProcent = zachmurzenieProcent;
        }
    }
    public PrognozaPogody(String Region, PrognozaPogody prognoza)
    {
        this.region=Region;
        this.temperatura = prognoza.getTemperatura();
        this.szansaNaDeszczProcent = prognoza.getSzansaNaDeszczProcent();
        this.zachmurzenieProcent = prognoza.getZachmurzenieProcent();
    }
    public PrognozaPogody()
    {
        temperatura = ThreadLocalRandom.current().nextInt(-270,6051);
        szansaNaDeszczProcent= ThreadLocalRandom.current().nextInt(0,100);
        zachmurzenieProcent= ThreadLocalRandom.current().nextInt(0,100);
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

    public String getRegion() {return region;}

    public int subiektywnaOcena()
    {
        int ocena = 0;
        if(isItWarm() ) ocena+=10;

        if(isItCloudy()) ocena+=5;
        else ocena += 10;

        if(isRainProbable()) ocena +=-5;
        else ocena+=5;

        if(isItDeadly()) ocena += -300;
        else ocena +=10;
        if(isItCold()) ocena += -5;

        return ocena;
    }

    private boolean isItCloudy() {
        return zachmurzenieProcent < 50;
    }

    private boolean isRainProbable() {
        return szansaNaDeszczProcent > 50;
    }

    private boolean isItWarm() {
        return temperatura > 20 && temperatura < 45;
    }
    private boolean isItCold()
    {
        return temperatura<0;
    }
    private boolean isItDeadly()
    {
        return temperatura < -60 || temperatura > 60;
    }

    @Override
    public int compareTo(Object o) {
        return ((Integer)this.subiektywnaOcena()).compareTo ( ((PrognozaPogody)o).subiektywnaOcena() );
    }

    @Override
    public String toString()
    {
        String opisOceny ="";
        int ocenaInt= subiektywnaOcena();
        if(ocenaInt>0)
        {
            if(ocenaInt>10) opisOceny="Ladnie";
            else opisOceny="Srednio";
        }
        else
        {
            if(ocenaInt > -10) opisOceny = "Brzydko";
            else opisOceny = "Zabojczo";
        }

        if(region =="")
        {
            return String.format("Możliwa pogoda. Temperatura: %d, Szansa na deszcz: %d%%, Zachmurzenie: %d%%. Ocena: %s",temperatura,szansaNaDeszczProcent,zachmurzenieProcent, opisOceny);
        }
        else
        {
            return String.format("Pogoda w %s. Temperatura: %d, Szansa na deszcz: %d%%, Zachmurzenie: %d%%. Ocena: %s",region,temperatura,szansaNaDeszczProcent,zachmurzenieProcent, opisOceny);
        }
    }
}

