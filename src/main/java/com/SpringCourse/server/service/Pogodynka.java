package com.SpringCourse.server.service;

import com.SpringCourse.server.domain.Prognoza;
import com.SpringCourse.server.repository.IForecastRepository;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class Pogodynka implements IPogodynka {
    String[] regiony;
    PrognozaPogody[] mozliwePrognozy;
    IForecastRepository forecastRepository;
    public Pogodynka(String[] regiony, PrognozaPogody[] mozliwePrognozy , IForecastRepository repository)
    {
        this.regiony =regiony;
        this.mozliwePrognozy = mozliwePrognozy;
        this.forecastRepository = repository;
    }
    public Pogodynka(PrognozaPogody[] mozliwePrognozy, IForecastRepository repository)
    {
        this( new String[]{ "Slask",
                        "Dolny Slask",
                        "Wielkopolska",
                        "Małopolska"
                }
                , mozliwePrognozy
                , repository
                );
    }

    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx, int prognozaIdx)
    {
        if((regionIdx>=0&&regionIdx<regiony.length)&&(prognozaIdx >=0&&prognozaIdx<mozliwePrognozy.length)) {
            PrognozaPogody obj = new PrognozaPogody(regiony[regionIdx], mozliwePrognozy[prognozaIdx]);
            savePrognoza(obj);
            return obj;
        }
        else
        {
            System.out.println(String.format("Niepoprawne indeksy: regionIdx= %d, prognozaIdx=%d.Zwracam random",regionIdx,prognozaIdx));
            PrognozaPogody obj =podajKonkretnaPrognozeDlaRegionu();
            return obj;
        }
    }
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx)
    {
        int prognozaIdx = ThreadLocalRandom.current().nextInt(0,mozliwePrognozy.length);
        if(regionIdx>=0&&regionIdx<regiony.length)
        {
            PrognozaPogody obj = new PrognozaPogody(regiony[regionIdx], mozliwePrognozy[prognozaIdx]);
            savePrognoza(obj);
            return obj;
        }
        else
        {
            System.out.println(String.format("Niepoprawne indeksy: regionIdx= %d. Zwracam random",regionIdx));
            PrognozaPogody obj = podajKonkretnaPrognozeDlaRegionu();

            return obj;
        }
    }
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu()
    {
        int prognozaIdx = ThreadLocalRandom.current().nextInt(0,mozliwePrognozy.length);
        int regionIdx = ThreadLocalRandom.current().nextInt(0,regiony.length);
        PrognozaPogody obj = new PrognozaPogody(regiony[regionIdx], mozliwePrognozy[prognozaIdx]);

        savePrognoza(obj);
        return obj;
    }
    public int getUpperBoundRegiony()
    {
        return regiony.length;
    }
    public int getUpperBoundPrognozy()
    {
        return regiony.length;
    }
    private void savePrognoza(PrognozaPogody prognozaDoZapisu){
        forecastRepository.save(new Prognoza(
                prognozaDoZapisu.getRegion(),
                prognozaDoZapisu.getTemperatura(),
                prognozaDoZapisu.getSzansaNaDeszczProcent(),
                prognozaDoZapisu.getZachmurzenieProcent()
        ));
    }
    public Collection<Prognoza> getAll(){

        return forecastRepository.findAll();
    }

}


