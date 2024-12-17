package main.com.test.javaDesignPatterns.builderAndExecutorDesignPattern;

public class StrikerAction implements PlayerAction {
    private String playerName;

    public StrikerAction(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void perform() {
        System.out.println(playerName + "-ը ծուռ ա։");
    }
}
