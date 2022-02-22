package com.bbo.resource;

import com.bbo.model.Fruit;
import com.bbo.model.Season;
import com.bbo.repository.FruitRepository;
import com.bbo.repository.FruityViceService;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/fruit")
public class FruitResource {
    @Inject
    private FruitRepository fruitRepository;
    @RestClient
    private FruityViceService fruityViceService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FruitDTO> fruits(@QueryParam("season") String season) {
        if (season != null) {
            Season s = Season.valueOf(season.toUpperCase());
            return fruitRepository.findBySeason(s)
                    .stream()
                    .map(f -> FruitDTO.of(f, fruityViceService.getFruitByName(f.name)))
                    .collect(Collectors.toList());
        }
        List<Fruit> allFruits = Fruit.<Fruit>listAll();
        return allFruits.stream()
                .map(fruit -> FruitDTO.of(fruit, fruityViceService.getFruitByName(fruit.name)))
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Fruit fruit) {
        fruit.id = null;
        fruit.persist();
        return Response.status(Response.Status.CREATED).entity(fruit).build();
    }
}
