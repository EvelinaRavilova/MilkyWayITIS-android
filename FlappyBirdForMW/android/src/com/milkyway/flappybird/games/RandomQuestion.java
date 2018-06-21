package com.milkyway.flappybird.games;

public class RandomQuestion {

    private static int a;
    private static int b;
    private static int sign;

    public static int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static int getSign() {
        return sign;
    }

    public static void generateQuestion() {
        a = (int)(1 + Math.random() * 99);
        sign = (int)(Math.random() * 4);
        switch(sign) {

            case 0: //+
                b = (int)(1 + Math.random() * 99);
                break;

            case 1: //-
                b = (int)(1 + Math.random() * a);
                break;

            case 2: //*
                b = (int)(1 + Math.random() * 20);
                break;

            case 3: //:
                b = (int)(1 + Math.random() * a);
                while(a % b != 0) {
                    b = (int)(1 + Math.random() * a);
                }
                break;
        }
    }
}
