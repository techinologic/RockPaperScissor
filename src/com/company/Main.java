package com.company;

import java.util.Random;
import java.util.Scanner;

class Main {

    private static String player1 = "";
    private static String player2 = "";
    private static final int[][] scores = new int[2][2];
    private static int rounds = 0;
    private static int games = 0;
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();
    private static String p2choice;

    public static void main(String[] args) {

        //Prompt user to choose between playing with player or computer
        System.out.print("Do you want to play with:\n[P]layer\n[C]omputer\n>>");
        String gameMode = sc.nextLine();

        if (gameMode.equalsIgnoreCase("P")) {

            vsPlayer();
        } else if (gameMode.equalsIgnoreCase("C")) {
            vsComputer();
        } else {
            System.out.println("Error: Choose P or C");
        }

    }

    //method that will return rock paper and scissor strings
    private static String winningChoice(String choice) {
        switch (choice.toUpperCase()) {
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
    private static void vsPlayer() {
        try {
            System.out.print("How many rounds? ");
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
            System.out.print(player1 + "'s Turn: \nChoose:\n[R]ock\n[P]aper\n[S]cissors\n>>");
            String p1choice = sc.nextLine();

            System.out.print(player2 + "'s Turn: \nChoose:\n[R]ock\n[P]aper\n[S]cissors\n>>");
            String p2choice = sc.nextLine();

            findWinnerRound(i, p1choice, p2choice);
            games++;

            declareWinner();
        }
    }

    private static void findWinnerRound(int i, String p1choice, String p2choice) {
        if (p1choice.equalsIgnoreCase("R") && p2choice.equalsIgnoreCase("S")) {
            System.out.println(player1 + " Wins round " + (i + 1) + "! " + winningChoice(p1choice) + " beats "
                    + winningChoice(p2choice));
            scores[0][0]++;
            scores[1][1]++;
            System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                    + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
        } else if (p1choice.equalsIgnoreCase("P") && p2choice.equalsIgnoreCase("R")) {
            System.out.println(player1 + " Wins round " + (i + 1) + "! " + winningChoice(p1choice) + " beats "
                    + winningChoice(p2choice));
            scores[0][0]++;
            scores[1][1]++;
            System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                    + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
        } else if (p1choice.equalsIgnoreCase("S") && p2choice.equalsIgnoreCase("P")) {
            System.out.println(player1 + " Wins round " + (i + 1) + "! " + winningChoice(p1choice) + " beats "
                    + winningChoice(p2choice));
            scores[0][0]++;
            scores[1][1]++;
            System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                    + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
        } else if (p1choice.equalsIgnoreCase("S") && p2choice.equalsIgnoreCase("R")) {
            System.out.println(player2 + " Wins round " + (i + 1) + "! " + winningChoice(p2choice) + " beats "
                    + winningChoice(p1choice));
            scores[0][1]++;
            scores[1][0]++;
            System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                    + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
        } else if (p1choice.equalsIgnoreCase("R") && p2choice.equalsIgnoreCase("P")) {
            System.out.println(player2 + " Wins round " + (i + 1) + "! " + winningChoice(p2choice) + " beats "
                    + winningChoice(p1choice));
            scores[0][1]++;
            scores[1][0]++;
            System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                    + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
        } else if (p1choice.equalsIgnoreCase("P") && p2choice.equalsIgnoreCase("S")) {
            System.out.println(player2 + " Wins round " + (i + 1) + "! " + winningChoice(p2choice) + " beats "
                    + winningChoice(p1choice));
            scores[0][1]++;
            scores[1][0]++;
            System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                    + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
        } else {
            System.out.println("It's a DRAW!");
            System.out.println("SCORE: " + player1 + " " + scores[0][0] + "W " + scores[0][1] + "L" + " vs. "
                    + player2 + " " + scores[1][0] + "W " + scores[1][1] + "L");
        }
    }

    private static void declareWinner() {
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

    //method that will run the game versus computer
    private static void vsComputer() {

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
            System.out.print(player1 + "'s Turn: \nChoose:\n[R]ock\n[P]aper\n[S]cissors\n>>");
            String p1choice = sc.nextLine();
            int n = rand.nextInt(3) + 1;

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
            findWinnerRound(i, p1choice, p2choice);
            games++;
            declareWinner();
        }
    }
}
