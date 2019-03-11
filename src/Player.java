public class Player {
    private String name;
    private Strategies strategy;

    public Player(String name, Strategies strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public Strategies getStrategy() {
        return strategy;
    }

}
