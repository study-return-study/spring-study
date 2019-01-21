package di_bean.pokedex.di.business.service;

import di_bean.pokedex.di.business.domain.Pokemon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

// 스프링의 유닛 테스트를 한다는 선언
@RunWith(SpringJUnit4ClassRunner.class)
// 유닛테스트에 사용할 config 기술
@ContextConfiguration(locations = {"/di_bean/pokedex/config/applicationContext.xml"})
//테스트 대상 인터페이스
public class PokedexServiceTest {
    // 테스트에 사용할 구현 오브젝트 인젝션
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