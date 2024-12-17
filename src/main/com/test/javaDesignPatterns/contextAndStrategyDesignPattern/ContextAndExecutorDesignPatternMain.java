package main.com.test.javaDesignPatterns.contextAndStrategyDesignPattern;

public class ContextAndExecutorDesignPatternMain {
        public static void main(String[] args) {
        RobotVacuumContext vacuum = new RobotVacuumContext();

        vacuum.setCleaningStrategy(new NormalCleaning());
        vacuum.startCleaning();
        System.out.println();

        vacuum.setCleaningStrategy(new DeepCleaning());
        vacuum.startCleaning();
        System.out.println();

        vacuum.setCleaningStrategy(new SpotCleaning());
        vacuum.startCleaning();
        System.out.println();

        vacuum.setCleaningStrategy(new EdgeCleaning());
        vacuum.startCleaning();
    }
}
