package without_di;

public class PokedexRun {
    // 웹 애플리케이션의 뷰와 컨트롤러를 대신하는 클래스

    public static void main(String args[]) {
        PokedexService pokedexService = new PokedexService();
        Pokemon pokemon = pokedexService.findByPokemonId(25);
        int totalBaseStats = pokedexService.calculateTotalBaseStats(pokemon);

        System.out.println(pokemon.getName() + "의 종족값의 합은 " + totalBaseStats + "입니다.");
    }
}
