package com.bbo.repository;

import com.bbo.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringFruitRepository extends JpaRepository<Fruit, Long> {

    public List<Fruit> findBySeason(String season);

}