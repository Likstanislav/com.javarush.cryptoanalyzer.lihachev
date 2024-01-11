import java.util.*;

public class BruteForce {
    private final Alphabet alphabet;

    public BruteForce(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String bruteForce(String originalText, int key) {
        return process(originalText, -key);
    }

    private String process(String originalText, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            Character originalChar = Character.toLowerCase(originalText.charAt(i));
            int originalCharIndex = alphabet.getCharIndex(originalChar);
            int newCharIndex = (alphabet.getSize() + (originalCharIndex + key)) % alphabet.getSize();
            result.append(alphabet.getCharByIndex(newCharIndex));
        }
        return result.toString();
    }
}
