package main.com.test.javaDesignPatterns.builderAndExecutorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class SoccerTeamBuilder {
    private List<PlayerAction> actions = new ArrayList<>();

    public SoccerTeamBuilder addStriker(String playerName) {
        actions.add(new StrikerAction(playerName));
        return this;
    }

    public SoccerTeamBuilder addDefender(String playerName) {
        actions.add(new DefenderAction(playerName));
        return this;
    }

    public SoccerTeamBuilder addMidfielder(String playerName) {
        actions.add(new MidfielderAction(playerName));
        return this;
    }

    public SoccerTeam build() {
        return new SoccerTeam(actions);
    }
}
