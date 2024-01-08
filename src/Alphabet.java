import java.util.*;

public class Alphabet {
    public static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    public static final Character[] SYMBOL = {'.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private final List<Character> alphabet = new ArrayList<>();

    public Alphabet() {
        alphabet.addAll(Arrays.asList(ALPHABET));
        alphabet.addAll(Arrays.asList(SYMBOL));
    }


    public Character getCharByIndex(int index) {
        return alphabet.get(index);
    }

    public int getCharIndex(Character character) {
        return alphabet.indexOf(character);
    }

    public int getSize() {
        return alphabet.size();
    }
}

