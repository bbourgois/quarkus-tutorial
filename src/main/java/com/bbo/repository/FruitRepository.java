package com.bbo.repository;

import com.bbo.model.Fruit;
import com.bbo.model.Season;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    public  List<Fruit> findBySeason(Season season) {
        return find("season", season).list();
    }
}
