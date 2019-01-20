package di_bean.pokedex.di.business.service;

import di_bean.pokedex.di.business.domain.Pokemon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/di_bean/pokedex/config/applicationContext.xml"})
public class PokedexServiceTest {
    @Autowired
    PokedexService pokedexService;

    @Test
    public void findPokemonById() {
        Pokemon raichu = new Pokemon(
                26,
                "라이츄",
                60,
                90
                ,55,
                90,
                80,
                110
        );

        pokedexService.addPokemon(raichu);
        Pokemon foundPokemon = pokedexService.findByPokemonId(26);
        assertEquals(raichu, foundPokemon);
    }
}