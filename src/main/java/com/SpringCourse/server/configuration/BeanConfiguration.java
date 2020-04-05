package com.SpringCourse.server.configuration;


import com.SpringCourse.server.service.IPogodynka;
import com.SpringCourse.server.service.Pogodynka;
import com.SpringCourse.server.service.PrognozaPogody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Value("${property.regiony}")
    private String [] regiony;

     @Bean
    public IPogodynka pogodynkaService() {

        PrognozaPogody[] mozliwePogody= new PrognozaPogody[]{
                new PrognozaPogody(10,10,10),
                new PrognozaPogody(-100,50,70),
                new PrognozaPogody(21,50,70),
                new PrognozaPogody(30,80,10),
                new PrognozaPogody(41,0,0),
                new PrognozaPogody(55,31,45),
                new PrognozaPogody(),
                new PrognozaPogody(),
                new PrognozaPogody()
        };
        return new Pogodynka(regiony,mozliwePogody);
    }
}

