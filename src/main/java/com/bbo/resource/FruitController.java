package com.bbo.resource;

import com.bbo.model.Fruit;
import com.bbo.model.Season;
import com.bbo.repository.SpringFruitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/fruit")
public class FruitController {

    private SpringFruitRepository fruitRepository;

    public FruitController(SpringFruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @GetMapping
    public List<Fruit> fruits(@RequestParam("season") String season) {
        if (season != null) {
            Season s = Season.valueOf(season.toUpperCase());
            return fruitRepository.findBySeason(s.name());
        }
        return Fruit.listAll();
    }

}
