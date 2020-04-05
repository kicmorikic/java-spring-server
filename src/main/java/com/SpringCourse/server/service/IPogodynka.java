package com.SpringCourse.server.service;

public interface IPogodynka {
    PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx, int prognozaIdx);
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx);
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu();
    public int getUpperBoundRegiony();
    public int getUpperBoundPrognozy();
}