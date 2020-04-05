package com.SpringCourse.server.controller;

import com.SpringCourse.server.domain.Prognoza;
import com.SpringCourse.server.service.IPogodynka;
import com.SpringCourse.server.service.PrognozaPogody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class WeatherForecastController {

    IPogodynka pogodynka;

    public WeatherForecastController(IPogodynka pogodynka){
        this.pogodynka = pogodynka;
    }

    @GetMapping("WeatherForecast")
    public PrognozaPogody WeatherForecast(@RequestParam(value = "region",required = false, defaultValue = "-1") Integer region, @RequestParam(value = "pogoda",required = false, defaultValue = "-1") Integer pogoda)
    {
        PrognozaPogody generated;
        if(region > 0&&pogoda <0){
            generated= pogodynka.podajKonkretnaPrognozeDlaRegionu(region);
        }
        else
        {
            generated= pogodynka.podajKonkretnaPrognozeDlaRegionu(region,pogoda);
        }
        return generated;
    }
    @GetMapping("GetAllWFServer")
    public Collection<Prognoza> getAllPrognoza()
    {
        Collection<Prognoza> coll = pogodynka.getAll();
        return coll;
    }

}
