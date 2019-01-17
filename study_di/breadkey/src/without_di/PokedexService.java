package without_di;

public class PokedexService {
    // 비즈니스 로직을 실현하는 클래스
    private PokemonDao pokemonDao;

    public PokedexService() {
        pokemonDao = new PokemonDao();
    }

    public Pokemon findByPokemonId(int id) {
        return pokemonDao.findByPokemonId(id);
    }

    public int calculateTotalBaseStats(Pokemon pokemon) {
        return pokemon.getHp() +
                pokemon.getAttack() +
                pokemon.getDefense() +
                pokemon.getSpecialAttack() +
                pokemon.getSpecialDefense() +
                pokemon.getSpeed();
    }
}
