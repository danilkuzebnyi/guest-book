package org.geekhub.danylo;

import java.util.Scanner;

public class Number {

    public static void main(String[] args) {
        String phoneNumber;
        String regex1, regex2, regex3;
        boolean validPhone;
        regex1 = "^\\+38\\(?03[9]\\)?\\d{7}|^\\+38\\(?05[0]\\)?\\d{7}|^\\+38\\(?06[3678]\\)?\\d{7}|^\\+38\\(?07[3]\\)?\\d{7}|^\\+38\\(?09[1-9]\\)?\\d{7}";
        regex2 = "^8\\(?03[9]\\)?\\d{7}|^8\\(?05[0]\\)?\\d{7}|^8\\(?06[3678]\\)?\\d{7}|^8\\(?07[3]\\)?\\d{7}|^8\\(?09[1-9]\\)?\\d{7}";
        regex3 = "^\\(?03[9]\\)?\\d{7}|^\\(?05[0]\\)?\\d{7}|^\\(?06[3678]\\)?\\d{7}|^\\(?07[3]\\)?\\d{7}|^\\(?09[1-9]\\)?\\d{7}";
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Input your telephone number: ");
            phoneNumber = in.nextLine();
            validPhone = phoneNumber.matches(regex1)||phoneNumber.matches(regex2)||phoneNumber.matches(regex3);
        } while (!validPhone);
        System.out.println("The phone number is correct!");
        in.close();

        long sum;
        int n = 0;
        do {
            sum = 0;
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (Character.isDigit(phoneNumber.charAt(i)))
                    sum += Character.getNumericValue(phoneNumber.charAt(i));
            }
            Long phoneNumberLong = Long.parseLong(phoneNumber);
            phoneNumberLong = sum;
            phoneNumber = phoneNumberLong.toString();
            n++;
            System.out.println(n + " round of calculation, sum is: " + sum);
        } while (sum > 9);

        if (sum == 1) {
            System.out.println("Final result is: One");
        } else if (sum == 2) {
            System.out.println("Final result is: Two");
        } else if (sum == 3) {
            System.out.println("Final result is: Three");
        } else if (sum == 4) {
            System.out.println("Final result is: Four");
        } else {
            System.out.println("Final result is: " + sum);
        }
    }
}

