package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void oneMonthCalendar(int days, int firstDay){
        int start = 1;
        int day = firstDay;
        while(start <= days){
            for(int i = 1; i <= 7; i++){
                if(i < day){
                    System.out.print("   ");
                }else if(start <= days){
                    System.out.printf("%2d ", start);
                    start++;
                }
            }
            System.out.println();
            day = 1;
        }
    }
    public static long[] lcg(long seed){
        long[] randomNumbers = new long[10];
        long m = 2147483648L;
        long a = 1103515245L;
        long c = 12345L;
        for(int i = 0; i < 10; i++){
            seed = (a * seed + c) % m;
            randomNumbers[i] = seed;
        }
        return randomNumbers;
    }
    public static int randomNumberBetweenOneAndHundred(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static void guessingGame(int numberToGuess){
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        int tries = 0;
        while(guess != numberToGuess && tries < 10){
            System.out.print("Guess number " + (tries + 1) + ": ");
            guess = scanner.nextInt();
            if(guess < numberToGuess){
                if(tries < 9){
                    System.out.println("The number AI picked is higher than your guess.");
                }
            }else if(guess > numberToGuess){
                if(tries < 9){
                    System.out.println("The number AI picked is lower than your guess.");
                }
            }
            tries++;
        }
        if(guess == numberToGuess){
            System.out.println("You won wisenheimer!");
        }else{
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }
    }
    public static boolean swapArrays(int[] array1, int[] array2){
        if(array1.length != array2.length){
            return false;
        }
        for(int i = 0; i < array1.length; i++){
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
        return true;
    }
    public static String camelCase(String sentence){
        char[] chars = sentence.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 'a' && chars[i] <= 'z'){
                if(first){
                    chars[i] -= 32;
                    first = false;
                }
                builder.append(chars[i]);
            }else if(chars[i] >= 'A' && chars[i] <= 'Z'){
                if(!first){
                    chars[i] += 32;
                }
                first = false;
                builder.append(chars[i]);
            }else if(chars[i] == ' '){
                first = true;
            }
        }
        return builder.toString();
    }
    public static int checkDigit(int[] code){
        int sum = 0;
        for(int i = 0; i < code.length; i++){
            sum += (i + 2) * code[i];
        }
        int rest = sum % 11;
        int difference = 11 - rest;
        if(difference == 10){
            return 0;
        }else if(difference == 11){
            return 5;
        }else{
            return difference;
        }
    }

    public static void main(String[] args) {
        App exercise3 = new App();
        exercise3.oneMonthCalendar(31, 1);


    }
}