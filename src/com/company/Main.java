package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static String player1 = "";
    static String player2 = "";
    static int[][] scores = new int[2][2];
    static int rounds = 0;
    static int games = 0;
    static String gameMode = "";
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static String p1choice;
    static String p2choice;

    public static void main(String[] args) {


        //Prompt user to choose between playing with player or computer
        System.out.println("Do you want to play with:\n[P]layer\n[C]omputer\n");
        gameMode = sc.nextLine();

        if (gameMode.equals("P")) {

            vsPlayer();
        } else {
            vsComputer();
        }

    }

    //method that will return rock paper and scissor strings
    public static String winningChoice(String choice) {

        switch (choice) {
            case "R":
                return "ROCK";

            case "P":
                return "PAPER";

            case "S":
                return "SCISSORS";
        }
        return "Error";
    }

    //method that will run the game versus player
    public static void vsPlayer() {

        try {

            System.out.print("How many rounds?");

            rounds = sc.nextInt();
            sc.nextLine();

            System.out.print("Player 1 name: ");
            player1 = sc.nextLine();


            System.out.print("Player 2 name: ");
            player2 = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(player1 + " vs. "
                + player2);

        for (int i = 0; i < rounds; i++) {
            System.out.println("\nGame # " + (i + 1) + " of " + rounds);
            System.out.print(player1 + "'s Turn: \nChoose:\n[R]ock\n[P]aper\n[S]cissor\n>>");
            String p1choice = sc.nextLine();

            System.out.print(player2 + "'s Turn: \nChoose:\n[R]ock\n[P]aper\n[S]cissor\n>>");
            String p2choice = sc.nextLine();

            if (p1choice.equals("R") && p2choice.equals("S")) {
                System.out.println(player1 + " Wins with " + winningChoice(p1choice) + " in round " + (i + 1));
                scores[0][0]++;
                scores[1][1]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("P") && p2choice.equals("R")) {
                System.out.println(player1 + " Wins with " + winningChoice(p1choice) + " in round " + (i + 1));
                scores[0][0]++;
                scores[1][1]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("S") && p2choice.equals("P")) {
                System.out.println(player1 + " Wins with " + winningChoice(p1choice) + " in round " + (i + 1));
                scores[0][0]++;
                scores[1][1]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("S") && p2choice.equals("R")) {
                System.out.println(player2 + " Wins with " + winningChoice(p2choice) + " in round " + (i + 1));
                scores[0][1]++;
                scores[1][0]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("R") && p2choice.equals("P")) {
                System.out.println(player2 + " Wins with " + winningChoice(p2choice) + " in round " + (i + 1));
                scores[0][1]++;
                scores[1][0]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("P") && p2choice.equals("S")) {
                System.out.println(player2 + " Wins with " + winningChoice(p2choice) + " in round " + (i + 1));
                scores[0][1]++;
                scores[1][0]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else {
                System.out.println("It's a DRAW!");
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            }
            games++;

            if (rounds == games) {

                if (scores[0][0] > scores[1][0]) {
                    System.out.println("\n" + player1 + " WINS THE GAME!");
                } else if (scores[0][0] < scores[1][0]) {
                    System.out.println("\n" + player2 + " WINS THE GAME!");
                } else {
                    System.out.println("\nIt's a DRAW!");
                }
            }
        }


    }

    //method that will run the game versus computer
    public static void vsComputer(){

        player2 = "RPS-COMPUTER";
        try {

            System.out.print("How many rounds?");

            rounds = sc.nextInt();
            sc.nextLine();

            System.out.print("Player 1 name: ");
            player1 = sc.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(player1 + " vs. "
                + player2);

        for (int i = 0; i < rounds; i++) {
            System.out.println("\nGame # " + (i + 1) + " of " + rounds);
            System.out.print(player1 + "'s Turn: \nChoose:\n[R]ock\n[P]aper\n[S]cissor\n>>");

            p1choice = sc.nextLine();


            int  n = rand.nextInt(3) + 1;

            try {

                switch (n) {
                    case 1:
                        p2choice = "R";
                        break;
                    case 2:
                        p2choice = "P";
                        break;
                    case 3:
                        p2choice = "S";
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (p1choice.equals("R") && p2choice.equals("S")) {
                System.out.println(player1 + " Wins with " + winningChoice(p1choice) + " in round " + (i + 1));
                scores[0][0]++;
                scores[1][1]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("P") && p2choice.equals("R")) {
                System.out.println(player1 + " Wins with " + winningChoice(p1choice) + " in round " + (i + 1));
                scores[0][0]++;
                scores[1][1]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("S") && p2choice.equals("P")) {
                System.out.println(player1 + " Wins with " + winningChoice(p1choice) + " in round " + (i + 1));
                scores[0][0]++;
                scores[1][1]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("S") && p2choice.equals("R")) {
                System.out.println(player2 + " Wins with " + winningChoice(p2choice) + " in round " + (i + 1));
                scores[0][1]++;
                scores[1][0]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("R") && p2choice.equals("P")) {
                System.out.println(player2 + " Wins with " + winningChoice(p2choice) + " in round " + (i + 1));
                scores[0][1]++;
                scores[1][0]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else if (p1choice.equals("P") && p2choice.equals("S")) {
                System.out.println(player2 + " Wins with " + winningChoice(p2choice) + " in round " + (i + 1));
                scores[0][1]++;
                scores[1][0]++;
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            } else {
                System.out.println("It's a DRAW!");
                System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                        + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
            }
            games++;

            if (rounds == games) {

                if (scores[0][0] > scores[1][0]) {
                    System.out.println("\n" + player1 + " WINS THE GAME!");
                } else if (scores[0][0] < scores[1][0]) {
                    System.out.println("\n" + player2 + " WINS THE GAME!");
                } else {
                    System.out.println("\nIt's a DRAW!");
                }
            }
        }

    }
}
