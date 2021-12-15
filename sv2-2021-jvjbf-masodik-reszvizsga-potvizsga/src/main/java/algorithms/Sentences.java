package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {

    private List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence) {
        if (isUpperCaseString(sentence)) {
            sentences.add(sentence);
        } else {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!")) {
            sentences.add(sentence);
        } else {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
    }

    private boolean isUpperCaseString(String sentence) {
        return Character.isUpperCase(sentence.charAt(0));
    }

    public String  findLongestSentence() {
        int max = sentences.get(0).length();
        String line = sentences.get(0);
        for (String st: sentences) {
            if (max < st.length()) {
                max = st.length();
                line = st;
            }
        }
        if (line == null) {
            throw new IllegalStateException("A lista nem lehet üres!");
        }
        return line;
    }

    public List<String> getSentences() {

        return new ArrayList<>(sentences);
    }
}
