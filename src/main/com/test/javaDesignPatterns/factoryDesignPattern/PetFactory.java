package main.com.test.javaDesignPatterns.factoryDesignPattern;

public class PetFactory {
    public static Pet createPet(String petType) {
        if (petType == null || petType.isEmpty()) {
            return null;
        }
        return switch (petType.toLowerCase()) {
            case "dog" -> new Dog();
            case "cat" -> new Cat();
            case "bird" -> new Bird();
            default -> throw new IllegalArgumentException("No such pet - " + petType);
        };
    }
}
