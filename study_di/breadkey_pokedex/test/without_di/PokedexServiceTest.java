package without_di;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokedexServiceTest {
    private PokedexService pokedexService = new PokedexService();
    Pokemon pikachu;
    @Before
    public void setUp() {
        pikachu = pokedexService.findByPokemonId(25);
    }

    @Test
    public void findByPokemonId() {
        assertEquals("피카츄", pikachu.getName());
    }

    @Test
    public void calculateTotalBaseStats() {
        assertEquals(320, pokedexService.calculateTotalBaseStats(pikachu));
    }
}