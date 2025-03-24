package com.example.anagram;

public class ReversWords {

    public static String anagramOfWords(String inputUser, String ignoreSymbol) {

        StringBuilder result = new StringBuilder();
        String[] words = inputUser.split(" ");

        for (String word : words) {
            char[] characters = new char[word.length()];
            char[] notIgnoredChars = new char[word.length()];

            int lastIndex = 0;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if ((!ignoreSymbol.isEmpty() && ignoreSymbol.contains(String.valueOf(currentChar))) ||
                        (ignoreSymbol.isEmpty() && !Character.isLetter(currentChar))) {
                    characters[i] = currentChar;
                } else {
                    notIgnoredChars[lastIndex++] = currentChar;
                }
            }

            int notIgnoredIndex = lastIndex - 1;
            for (int i = 0; i < word.length(); i++) {
                if (characters[i] == 0) {
                    characters[i] = notIgnoredChars[notIgnoredIndex--];
                }
            }
            result.append(new String(characters)).append(" ");
        }
        return result.toString().trim();
    }
}