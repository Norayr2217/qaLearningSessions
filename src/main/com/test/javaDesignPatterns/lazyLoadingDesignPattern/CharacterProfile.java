package main.com.test.javaDesignPatterns.lazyLoadingDesignPattern;

public class CharacterProfile {
    private final String name;
    private final String attributes;
    private final String weapon;

    public CharacterProfile(String name, String attributes, String weapon) {
        this.name = name;
        this.attributes = attributes;
        this.weapon = weapon;
    }

    public void load() {
        System.out.println("Loading character: " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Character loaded: " + name);
    }

    @Override
    public String toString() {
        return "CharacterProfile{" +
                "name='" + name + '\'' +
                ", attributes='" + attributes + '\'' +
                ", skills='" + weapon + '\'' +
                '}';
    }
}