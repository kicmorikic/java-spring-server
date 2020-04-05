package com.SpringCourse.server.service;

import com.SpringCourse.server.domain.Prognoza;

import java.util.Collection;

public interface IPogodynka {
    PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx, int prognozaIdx);
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu(int regionIdx);
    public PrognozaPogody podajKonkretnaPrognozeDlaRegionu();
    public Collection<Prognoza> getAll();
    public int getUpperBoundRegiony();
    public int getUpperBoundPrognozy();
}