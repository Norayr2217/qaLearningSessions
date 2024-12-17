package main.com.test.javaDesignPatterns.commandAndExecutorDesignPattern;

public class CommandAndExecutorDesignPatternMain {
        public static void main(String[] args) {
        Spaceship spaceship = new Spaceship();
        ControlSystem controlSystem = new ControlSystem();

        Command accelerate = new AccelerateCommand(spaceship);
        Command turnLeft = new TurnCommand(spaceship, -90);
        Command turnRight = new TurnCommand(spaceship, 90);
        Command hyperJump = new HyperjumpCommand(spaceship);

        controlSystem.setCommand(accelerate);
        controlSystem.pressButton();
        System.out.println();

        controlSystem.setCommand(turnLeft);
        controlSystem.pressButton();
        System.out.println();

        controlSystem.setCommand(turnRight);
        controlSystem.pressButton();
        System.out.println();

        controlSystem.setCommand(hyperJump);
        controlSystem.pressButton();
    }
}
