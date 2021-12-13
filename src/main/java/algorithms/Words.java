package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        if (isOneWord(word) && isLowerCase(word)) {
            words.add(word);
        }
    }

    public boolean isThereAWordTwice() {
        boolean isThereTwice = false;
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size() - 1; j++) {
                if (words.get(i).equals(words.get(j))) {
                    isThereTwice = true;
                }
            }
        }
        return isThereTwice;
    }

    private boolean isOneWord(String word) {
        if (word.indexOf(" ") == -1) {
            return true;
        }
        throw new IllegalArgumentException("It should be one word!");
    }

    private boolean isLowerCase(String word) {
        String lowerCase = word.toLowerCase();
        if (word.equals(lowerCase)) {
            return true;
        }
        throw new IllegalArgumentException("Word should be lower case!");
    }
}
