package main.com.test.javaDesignPatterns.commandAndExecutorDesignPattern;

public class TurnCommand implements Command {
    private final Spaceship spaceship;
    private final int angle;

    public TurnCommand(Spaceship spaceship, int angle) {
        this.spaceship = spaceship;
        this.angle = angle;
    }

    @Override
    public void execute() {
        spaceship.turn(angle);
    }
}