package org.geekhub.danylo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tooLongWords {

    public static void main(String[] args) throws IOException {
        System.out.print("Enter an integer n (1<=n<=100): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String qtyOfLines = reader.readLine();
        int n = Integer.parseInt(qtyOfLines);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a word: ");
            String word = reader.readLine();
            System.out.print("Abbreviated word: ");
            System.out.println(String.valueOf(word.charAt(0)) + (word.length() - 2) + word.charAt(word.length() - 1));
        }
    }
}
