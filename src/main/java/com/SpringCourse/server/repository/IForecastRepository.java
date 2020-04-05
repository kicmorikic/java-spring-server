package com.SpringCourse.server.repository;

import com.SpringCourse.server.domain.Prognoza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IForecastRepository extends CrudRepository<Prognoza, Long> {
    Collection<Prognoza> findAll();
}
