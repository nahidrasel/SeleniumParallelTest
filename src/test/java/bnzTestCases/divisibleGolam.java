package bnzTestCases;

import java.util.Scanner;

public class divisibleGolam {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Number:");
        int num = sc.nextInt();

        if ((num % 5 == 0 )&& (num % 6 == 0)) {
            System.out.println(num + " Number is divisible by 5 and 6 ");
        } else if ((num % 5 == 0 )|| (num % 6 == 0)) {
            System.out.println(num + " Number is divisible by 5 or 6 ");
        } else {
            System.out.println(num + " Number is not divisible by neither 5 and 6 ");
        }
    }
}
