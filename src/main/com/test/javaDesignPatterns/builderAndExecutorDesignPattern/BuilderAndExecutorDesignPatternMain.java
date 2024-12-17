package main.com.test.javaDesignPatterns.builderAndExecutorDesignPattern;

public class BuilderAndExecutorDesignPatternMain {
    public static void main(String[] args) {
        SoccerTeam team = new SoccerTeamBuilder()
                .addStriker("Երվանդ")
                .addMidfielder("Նորայր")
                .addDefender("Արամ")
                .build();

        team.play();
        System.out.println();
        System.out.println("______________________");
        System.out.println();

        SoccerTeamExecutor.execute(team);
    }
}
