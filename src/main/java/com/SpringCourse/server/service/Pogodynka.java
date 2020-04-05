package com.SpringCourse.server.service;

import java.util.concurrent.ThreadLocalRandom;

public class Pogodynka implements IPogodynka {
    String[] regiony;
    PrognozaPogody[] mozliwePrognozy;
    public Pogodynka(String[] regiony,PrognozaPogody[] mozliwePrognozy )
    {
        this.regiony =regiony;
        this.mozliwePrognozy = mozliwePrognozy;
    }
    public Pogodynka(PrognozaPogody[] mozliwePrognozy)
    {
        this( new String[]{ "Slask",
                        "Dolny Slask",
                        "Wielkopolska",
                        "Małopolska"
                }
                , mozliwePrognozy);
    }

    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx, int prognozaIdx)
    {
        if((regionIdx>=0&&regionIdx<regiony.length)&&(prognozaIdx >=0&&prognozaIdx<mozliwePrognozy.length)) {
            return new PrognozaPogody(regiony[regionIdx], mozliwePrognozy[prognozaIdx]);
        }
        else
        {
            System.out.println(String.format("Niepoprawne indeksy: regionIdx= %d, prognozaIdx=%d.Zwracam random",regionIdx,prognozaIdx));
            return podajKonkretnaPrognozeDlaRegionu();
        }
    }
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx)
    {
        int prognozaIdx = ThreadLocalRandom.current().nextInt(0,mozliwePrognozy.length);
        if(regionIdx>=0&&regionIdx<regiony.length)
        {
            return new PrognozaPogody(regiony[regionIdx], mozliwePrognozy[prognozaIdx]);
        }
        else
        {
            System.out.println(String.format("Niepoprawne indeksy: regionIdx= %d. Zwracam random",regionIdx));
            return podajKonkretnaPrognozeDlaRegionu();
        }
    }
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu()
    {
        int prognozaIdx = ThreadLocalRandom.current().nextInt(0,mozliwePrognozy.length);
        int regionIdx = ThreadLocalRandom.current().nextInt(0,regiony.length);
        return new PrognozaPogody(regiony[regionIdx], mozliwePrognozy[prognozaIdx]);
    }
    public int getUpperBoundRegiony()
    {
        return regiony.length;
    }
    public int getUpperBoundPrognozy()
    {
        return regiony.length;
    }

}


