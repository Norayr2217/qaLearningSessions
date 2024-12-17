package main.com.test.javaDesignPatterns.lazyLoadingDesignPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CharacterManager {
    private final Map<String, Supplier<CharacterProfile>> characterSuppliers = new HashMap<>();
    private final Map<String, CharacterProfile> loadedCharacters = new HashMap<>();

    public void registerCharacter(String key, Supplier<CharacterProfile> characterSupplier) {
        characterSuppliers.put(key, characterSupplier);
    }

    public CharacterProfile getCharacter(String key) {
        if (!loadedCharacters.containsKey(key)) {  //is character loaded
            CharacterProfile character = characterSuppliers.get(key).get();
            character.load();
            loadedCharacters.put(key, character);
        }
        return loadedCharacters.get(key);
    }
}