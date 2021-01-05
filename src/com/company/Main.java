package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String input[];
    static String turn;
     static String Main(){
        for(int i=0;i<8;i++){//kitni lines ban skti hai
            String line = null;
            if(i==0){
                line=input[0]+input[1]+input[2];
            }
            else if(i==1){
                line=input[3]+input[4]+input[5];

            }
            else if(i==2){
                line=input[6]+input[7]+input[8];

            }
            else if(i==3){
                line=input[0]+input[3]+input[6];

            }
            else if(i==4){
                line=input[1]+input[4]+input[7];

            }
            else if(i==5){
                line=input[2]+input[5]+input[8];

            }
            else if(i==6){
                line=input[0]+input[4]+input[8];

            }
            else if(i==7){
                line=input[2]+input[4]+input[6];

            }
            else{
                break;
            }
            if(line.equals("XXX")){
                System.out.println("X Wins!!!");
                break;
            }
            else if(line.equals("OOO")){
                System.out.println("O Wins!!!");
            }
        }

        for(int i=0;i<9;i++){//konse and kitne dabbe
            if(Arrays.asList(input).contains(String.valueOf(i+1))){
                break;
            }
            else if(i==8){
                return "draw";
            }
        }
        System.out.println(turn + "  Enter the input number to place  " + turn);


        return null;
    }
    public static void Board(){

        System.out.println("|---|---|---|");
        System.out.println("| " + input[0] + " | "
                + input[1] + " | " + input[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + input[3] + " | "
                + input[4] + " | " + input[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + input[6] + " | "
                + input[7] + " | " + input[8]
                + " |");
        System.out.println("|---|---|---|");

    }

    public static void main(String[] args) {
	// write your code here

        Scanner in = new Scanner(System.in);
        input= new String[9];
        String Winner = null;
        turn="X";
        for (int i = 0; i < 9; i++) {//??
            input[i] = String.valueOf(i + 1);
        }
        System.out.println("Let's start the game!!!");
        Board();
        System.out.println("X will start the game");
        System.out.println("Make a valid input");
        System.out.println("Input: ");

        while(Winner==null){
            int number;
            try{
                number = in.nextInt();
                if ( !(number > 0 && number <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }

            }
            catch (InputMismatchException exception){
                System.out.println("Try Again!!!");
                continue;
            }
            if(input[number-1].equals(String.valueOf(number))){
                input[number-1]=turn;
                if(turn.equals("X")){
                    turn="O";

                }
                else{
                    turn="X";
                }
                Board();
                Winner=Main();

            }
            else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }
        if(Winner.equalsIgnoreCase("draw")){
            System.out.println("Thankyou for playing, It's a draw!!!");
        }
        else{
            System.out.println(Winner + "is the winner");
        }


    }
}
