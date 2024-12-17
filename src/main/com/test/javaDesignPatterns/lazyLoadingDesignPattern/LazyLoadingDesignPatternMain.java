package main.com.test.javaDesignPatterns.lazyLoadingDesignPattern;

public class LazyLoadingDesignPatternMain {
        public static void main(String[] args) {
        CharacterManager characterManager = new CharacterManager();

        characterManager.registerCharacter("warrior", () -> new CharacterProfile("Warrior", "Strength: 10", "Sword and shield"));
        characterManager.registerCharacter("mage", () -> new CharacterProfile("Mage", "Intelligence: 10", "Spell casting"));
        characterManager.registerCharacter("archer", () -> new CharacterProfile("Archer", "Aim: 10", "Bow and arrow"));

        System.out.println("Loading Warrior");
        CharacterProfile warrior = characterManager.getCharacter("warrior");
        System.out.println(warrior);

        System.out.println("\nLoading Mage");
        CharacterProfile mage = characterManager.getCharacter("mage");
        System.out.println(mage);

        System.out.println("\nLoading Archer");
        CharacterProfile archer = characterManager.getCharacter("archer");
        System.out.println(archer);

        System.out.println("\nLoading Warrior again:");
        CharacterProfile warriorAgain = characterManager.getCharacter("warrior");
        System.out.println(warriorAgain);
    }
}
