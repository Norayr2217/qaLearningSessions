package main.com.test.javaDesignPatterns.commandAndExecutorDesignPattern;

public class AccelerateCommand implements Command {
    private Spaceship spaceship;

    public AccelerateCommand(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public void execute() {
        spaceship.accelerate();
    }
}
