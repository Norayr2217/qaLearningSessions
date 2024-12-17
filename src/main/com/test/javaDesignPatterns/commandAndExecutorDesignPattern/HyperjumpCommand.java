package main.com.test.javaDesignPatterns.commandAndExecutorDesignPattern;

public class HyperjumpCommand implements Command {
    private final Spaceship spaceship;

    public HyperjumpCommand(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public void execute() {
        spaceship.hyperjump();
    }
}
