import java.util.*;

public class BruteForce {
    private final Alphabet alphabet;


    public BruteForce(Alphabet alphabet) {

        this.alphabet = alphabet;
    }

    public String bruteForce(String originalText) {
        return process(originalText);
    }

    private String process(String originalText) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            Character originalChar = toLowerCase(originalText.charAt(i));
            int originalCharIndex = alphabet.getCharIndex(originalChar);
            int newCharIndex = (alphabet.getSize() + (originalCharIndex)) % alphabet.getSize();
            result.append(alphabet.getCharByIndex(newCharIndex));
        }
        return result.toString();
    }

    private Character toLowerCase(Character character) {
        return (character + "").toLowerCase().charAt(0);
    }
}
