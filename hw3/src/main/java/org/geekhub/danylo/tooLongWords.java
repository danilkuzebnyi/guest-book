package org.geekhub.danylo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class tooLongWords {

    public static void main(String[] args) throws IOException {
        System.out.print("Enter an integer n (1<=n<=100): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String qtyOfLines = reader.readLine();
        int n = Integer.parseInt(qtyOfLines);

        List<String> listOfWords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a word: ");
            String word = reader.readLine();
            if (word.length() > 10) {
                String abbreviatedWord = String.valueOf(word.charAt(0)) + (word.length() - 2)
                                                        + word.charAt(word.length() - 1);
                listOfWords.add(abbreviatedWord);
            }
            else {
                listOfWords.add(word);
            }
        }
        System.out.println("Abbreviated words: ");
        for (String word:listOfWords) {
            System.out.println(word);
        }
    }
}
