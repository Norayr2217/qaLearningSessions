package main.com.test.javaDesignPatterns.builderAndExecutorDesignPattern;

import java.util.List;

public class SoccerTeam {
    private final List<PlayerAction> playerActions;

    public SoccerTeam(List<PlayerAction> playerActions) {
        this.playerActions = playerActions;
    }

    public void play() {
        for (PlayerAction action : playerActions) {
            action.perform();
        }
    }
}
