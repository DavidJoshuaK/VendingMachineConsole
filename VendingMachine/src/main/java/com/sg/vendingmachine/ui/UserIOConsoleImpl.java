/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserIOConsoleImpl implements UserIO {
     Scanner sc = new Scanner(System.in);
    String input = "";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        print(prompt);
        input = sc.nextLine();
        return Double.parseDouble(input);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        do {
            print(prompt);
            input = sc.nextLine();
        } while (Double.parseDouble(input) < min || Double.parseDouble(input) > max);

        return Double.parseDouble(input);
    }

    @Override
    public float readFloat(String prompt) {
        print(prompt);
        input = sc.nextLine();
        return Float.parseFloat(input);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {

        do {
            print(prompt);
            input = sc.nextLine();
        } while (Float.parseFloat(input) < min || Float.parseFloat(input) > max);

        return Float.parseFloat(input);
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        input = sc.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int inputInt = 0;
        do {
            print(prompt);
            while (!sc.hasNextInt()) {
                input = sc.nextLine();
            }
            input=sc.nextLine();
            inputInt = Integer.parseInt(input);
        } while (inputInt < min || inputInt > max);

        return inputInt;
    }

    @Override
    public long readLong(String prompt) {
        print(prompt);
        input = sc.nextLine();
        return Long.parseLong(input);
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        do {
            print(prompt);
            input = sc.nextLine();
        } while (Long.parseLong(input) < min || Long.parseLong(input) > max);

        return Long.parseLong(input);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        input = sc.nextLine();
        return input;
    }

}
