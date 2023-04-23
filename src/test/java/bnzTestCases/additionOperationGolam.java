package bnzTestCases;

import java.util.Scanner;

public class additionOperationGolam {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The First Number:");
        int num1 = sc.nextInt();

        System.out.println("Enter The Second Number:");
        int num2 = sc.nextInt();
        int result = num1 + num2;

        System.out.println("Enter The Sum:");
        int sum = sc.nextInt();

        if (sum == result) {
            System.out.println("Success");
        } else {
            System.out.println("Failed, try again!");
        }
    }
}
