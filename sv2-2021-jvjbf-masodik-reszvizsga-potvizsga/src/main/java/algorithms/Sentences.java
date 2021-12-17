package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {

    private List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence) {
        if (isUpperCaseString(sentence)) {
            if (isEndStringCorrect(sentence)) {
                sentences.add(sentence);
            } else {
                throw new IllegalArgumentException("Sentence must end with ending mark!");
            }
        } else {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
    }

    private boolean isEndStringCorrect(String sentence) {
        return sentence.endsWith(".")  || sentence.endsWith("?") || sentence.endsWith("!");
    }

    private boolean isUpperCaseString(String sentence) {
        return Character.isUpperCase(sentence.charAt(0));
    }

    public String  findLongestSentence() {
        if (sentences.size() == 0) {
            throw new IllegalStateException("A sor nem lehet üres!");
        }
        int max = sentences.get(0).length();
        String line = sentences.get(0);
        for (String st: sentences) {
            if (max < st.length()) {
                max = st.length();
                line = st;
            }
        }
        return line;
    }

    public List<String> getSentences() {
        return new ArrayList<>(sentences);
    }
}
