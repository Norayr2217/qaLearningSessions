package main.com.test.javaDesignPatterns.commandAndExecutorDesignPattern;

public class ControlSystem {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}
