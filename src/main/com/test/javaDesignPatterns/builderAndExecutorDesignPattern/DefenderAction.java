package main.com.test.javaDesignPatterns.builderAndExecutorDesignPattern;

public class DefenderAction implements PlayerAction {
    private String playerName;

    public DefenderAction(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void perform() {
        System.out.println(playerName + "-ը ծխում ա։");
    }
}
