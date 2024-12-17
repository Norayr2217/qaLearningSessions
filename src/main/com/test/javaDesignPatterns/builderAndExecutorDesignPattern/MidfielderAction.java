package main.com.test.javaDesignPatterns.builderAndExecutorDesignPattern;

public class MidfielderAction implements PlayerAction {
    private String playerName;

    public MidfielderAction(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void perform() {
        System.out.println(playerName + "-ը դժգոհ ա։");
    }
}
