/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Chris Mathew
 */
package base;

import java.text.NumberFormat;
import java.util.Scanner;

public class App
{
    static Scanner in = new Scanner(System.in);
    static NumberFormat money = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {

        System.out.println("What is the order amount?  ");
        String amount = in.nextLine();
        System.out.println("What state do you live in?  ");
        String state = in.nextLine();

        double a = Double.parseDouble(amount);
        double rate = 0;

        switch (state) {
            case "Illinois":
                rate = 0.08;
                break;
            case "Wisconsin":
                rate = 0.05;
                System.out.println("What county do you live in?  ");
                String county = in.nextLine();
                switch (county) {
                    case "Eau Claire":
                        rate += 0.005;
                        break;
                    case "Dunn":
                        rate += 0.004;
                        break;
                    default:
                        rate = 0.05;
                        break;
                }
                break;
            default:
                rate = 0;
                break;
        }
        double tax = a * rate;
        double total = tax + a;

        System.out.println("The tax is " + money.format(tax) + ".\nThe total is " + money.format(total) + ".");

    }
}
