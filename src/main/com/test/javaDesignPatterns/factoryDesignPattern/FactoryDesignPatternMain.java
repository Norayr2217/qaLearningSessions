package main.com.test.javaDesignPatterns.factoryDesignPattern;

public class FactoryDesignPatternMain {
        public static void main(String[] args) {
        Pet dog = PetFactory.createPet("dog");
        dog.makeNoise();
        System.out.println();

        Pet cat = PetFactory.createPet("cat");
        cat.makeNoise();
        System.out.println();

        Pet bird = PetFactory.createPet("bird");
        bird.makeNoise();
        System.out.println();

        try {
            Pet unknown = PetFactory.createPet("snake");
            unknown.makeNoise();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
