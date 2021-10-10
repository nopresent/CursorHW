package com.cursorhw.hw1;

public class Main {

    public static void main(String[] args) {

        // byte short
        byte b1 = 13;
        short s1 = 15_001;
        System.out.println("       -> +: " + (b1 + s1));
        System.out.println("       -> *: " + (b1 * s1));

        // short double float
        short s2 = -17;
        short s3 = 356;
        double double_s_Result = s2 / (double) s3;

        System.out.println(" float -> /: " + (float) s2 / s3);
        System.out.println("double -> /: " + double_s_Result);

        // long
        long l1 = 2_000_000L;
        long l2 = 5_000L;
        System.out.println("       -> -: " + (l1 - l2));

    }
}
