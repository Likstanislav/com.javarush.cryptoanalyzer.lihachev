import java.util.*;

public class Encryption {
    private final Alphabet alphabet;

    public Encryption(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String originalText, int key) {
        return process(originalText, key);
    }

    private String process(String originalText, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            Character originalChar = toLowerCase(originalText.charAt(i));
            int originalCharIndex = alphabet.getCharIndex(originalChar);
            int newCharIndex = (alphabet.getSize() + (originalCharIndex + key)) % alphabet.getSize();
            result.append(alphabet.getCharByIndex(newCharIndex));
        }
        return result.toString();
    }

    private Character toLowerCase(Character character) {
        return (character + "").toLowerCase().charAt(0);
    }

}
