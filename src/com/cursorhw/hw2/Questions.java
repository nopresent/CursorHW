package com.cursorhw.hw2;

import java.util.Arrays;
import java.util.Collections;

import static com.cursorhw.hw2.SystemCore.*;

public class Questions {

    public void question1() {
        String Question = "Google about class Arrays";
        String Answer = "https://www.geeksforgeeks.org/array-class-in-java/";
        printQuestionAnswer(Question, Answer);
    }

    public void question2() {
        String Question = "Find the answer to the next question: Why arrays in java initialize with fixed size and can’t be dynamic?";
        String Answer = "The length of an array is established when the array is created. After creation, its length is fixed \n" +
                "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html ";
        printQuestionAnswer(Question, Answer);
    }

    public void question3() {
        String Question = "Create next array of Integers with values: 2,3,1,7,11. Sort them by DESC(reverseOrder).";
        Integer[] myArray = {2, 3, 1, 7, 11};
        Arrays.sort(myArray, Collections.reverseOrder());
        printQuestionAnswer(Question, Arrays.toString(myArray));
    }

    public void question4() {
        String Question = "You get an array of numbers(should contain both positive and negative numbers), and return the sum of all the positive ones. (If there are nothing to sum, sum should be 0)";
        int[] myArrayWithPositive = {2, 3, -1, 7, 11, -4, 0, -5};
        int[] myArrayWithOutPositive = {-1, -4, -5};
        String Answer = "Sum of all the positive in Array " + Arrays.toString(myArrayWithPositive) + " is: " + sumPositiveArray(myArrayWithPositive) + "\n" +
                "Sum of all the positive in Array " + Arrays.toString(myArrayWithOutPositive) + " is: " + sumPositiveArray(myArrayWithOutPositive);
        printQuestionAnswer(Question, Answer);
    }

    public void question5() {
        String Question = "You get an array of numbers, return the average of a list of numbers in this array. (Example -  array{1,2,4,1} -> avg = 2)";
        int sumNumbersOfArray = 0;
        int[] myArrayWithPositive = {2, 3, -1, 7, 11, -4, 0, -5};
        for (int j : myArrayWithPositive) {
            sumNumbersOfArray += j;
        }
        float result = sumNumbersOfArray / (float) myArrayWithPositive.length;
        String Answer = "Average value of array numbers " + Arrays.toString(myArrayWithPositive) + " is: " + result;
        printQuestionAnswer(Question, Answer);
    }

    public void question6() {
        int[] Array = {3, 2, 3, 1, 4, 2, 8, 3};
        String Question = "You have array " + Arrays.toString(Array) + ". Replace all duplicated values by 0. Result should be  next: {3,2,0,1,4,0,8,0}";
        String Answer = "Result: " + Arrays.toString(replaceDuplicateForUsers(Array));
        printQuestionAnswer(Question, Answer);
    }

}
