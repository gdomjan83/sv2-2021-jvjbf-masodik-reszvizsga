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
        for (int i = 0; i < words.size(); i++) {
            if (isSameWord(i, words.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameWord(int wordIndex, String wordToCompare) {
        for (int j = wordIndex + 1; j < words.size() - 1; j++) {
            if (wordToCompare.equals(words.get(j))) {
                return true;
            }
        }
        return false;
    }

    private boolean isOneWord(String word) {
        if (word.trim().indexOf(" ") == -1) {
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
