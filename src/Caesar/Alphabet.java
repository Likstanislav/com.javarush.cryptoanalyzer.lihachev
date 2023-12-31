package Caesar;

import java.util.*;

public class Alphabet {
    public static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private final List<Character> alphabet;

    private final Map<Character, Integer> charIndexes;

    public Alphabet() {
        List<Character> tempAlphabet = new ArrayList<>();
        tempAlphabet.addAll(Arrays.asList(ALPHABET));

        alphabet = List.copyOf(tempAlphabet);

        charIndexes = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            charIndexes.put(alphabet.get(i), i);
        }
    }


    public Character getCharByIndex(int index) {
        if (index < 0 || index > alphabet.size()) {
            throw new RuntimeException();
        }
        return alphabet.get(index);
    }

    public int getCharIndex(Character character) {
        if (!charIndexes.containsKey(character)) {
            throw new RuntimeException();
        }
        return charIndexes.get(character);
    }

    public int getSize() {
        return alphabet.size();
    }
}

