package com.duckrace.controller;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

//application controller- sets up the system objects, orchestrates overall flow of app
//prompts user for inputs and forward those input into the system.
public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in); //read inputs from console
    private final Board board = Board.getInstance();

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        upDateBoard(id, reward);
        showBoard();
    }

    private void upDateBoard(int id, Reward reward) {
        board.update(id, reward);

    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please Enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                validInput = true;
                reward = ("D".equals(input)) ? Reward.DEBIT_CARD: Reward.PRIZES ;

//                if ("D".equals(input)) {
//                    reward = Reward.DEBIT_CARD;
//                }
//                else {
//                    reward = Reward.PRIZES;
//                }
            }
        }

        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter id of the winner [1-13]: ");  //todo: dont hardcode 13
            String input = scanner.nextLine().trim(); //removes whitespace characters
            if (input.matches("\\d{1,2}")) {   //any digit one or two occurrences
                id = Integer.parseInt(input); // safe to convert to int at this point
                if (1 <= id && id <= 13) {   //valid id
                    validInput = true;
                }
            }
        }

        return id;
    }

    private void showBoard() {
        board.show();


    }

    private void welcome() {
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println("W E L C O M E  T O  T H E  D U C K  R A C E  A P P I C A T I O N");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
    }


}