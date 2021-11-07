package org.geekhub.danylo;

import java.util.Scanner;

public class Number {

    public static void main(String[] args) {

        String number, regex;
        boolean flag;
        regex = "\\d+";
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Input your telephone number: ");
            number = in.nextLine();
            flag = ( ( number.startsWith("+380") && number.length() == 13 && number.substring(1).matches(regex) )
                    || ( number.startsWith("0") && number.length() == 10 && number.matches(regex) )
                    || ( number.startsWith("8") && number.length() == 11 && number.matches(regex) ) );
        } while (!flag);
        in.close();

        if ( ( number.startsWith("+380") && number.length() == 13 && number.substring(1).matches(regex) )
                || ( number.startsWith("0") && number.length() == 10 && number.matches(regex) )
                || ( number.startsWith("8") && number.length() == 11 && number.matches(regex) ) ) {

            System.out.println("The phone number is correct!");
            int sum = 0;
            for (int i = 0; i < number.length(); i++) {
                if (Character.isDigit(number.charAt(i)))
                    sum += Character.getNumericValue(number.charAt(i));
            }
            System.out.println("1st round of calculation, sum is: " + sum);

            int sum2 = 0;
            while (sum > 9) {
                sum2 = 0;
                String str_sum = String.valueOf(sum);
                for (int i = 0; i < str_sum.length(); i++) {
                    sum2 += Character.getNumericValue(str_sum.charAt(i));
                }
                sum = sum2;
                System.out.println("2nd round of calculation, sum is: " + sum2);
            }
            
            switch (sum2) {
                case 1:
                    System.out.println("Final result is: One");
                    break;
                case 2:
                    System.out.println("Final result is: Two");
                    break;
                case 3:
                    System.out.println("Final result is: Three");
                    break;
                case 4:
                    System.out.println("Final result is: Four");
                    break;
                default:
                    System.out.println("Final result is: " + sum2);
            }

        }
    }
}
