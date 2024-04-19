package com.cm6123.wormhole.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *gets user prompts when the game starts up.
 */
public class Gamestartup {
    /**
     * This integer defines the player amount.
     */
    private int playernumber;

    /**
     * This integer defines the dimensions of the board.
     */
    private int boarddimensions;

    /**
     * This private list contains the list of the players.
     */
    private List<Player> players = new ArrayList<>();

    /**
     * Gets the desired number of players and their names.
     */
    public void fetchplayers() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        Player pla = new Player();
        while (!valid) {
            System.out.println("How many players are playing? please select a number between 2-6");
            playernumber = sc.nextInt();
            if (playernumber <= 6 && playernumber >= 2) {
                valid = true;
            } else {
                System.out.print("Player size invalid :/ please try again!");
            }
        }


        System.out.println("Current player size = " + playernumber + "! :)");


        for (int x = 0; x < playernumber; x++) {
            System.out.println("Please enter player" + (x+1) + "'s name");
            String t = sc.next();
            boolean compDice = false;
            String cD;
            boolean valid2 = false;
            while (!valid2) {
                System.out.println("Do you have dice at hand you can roll? (Y/N)");
                cD = sc.next();
                valid2 = true;
                if (Objects.equals(cD, "Y") || Objects.equals(cD, "y") || Objects.equals(cD, "Yes") || Objects.equals(cD, "yes")  || Objects.equals(cD, "N") || Objects.equals(cD, "n") || Objects.equals(cD, "No") || Objects.equals(cD, "no")) {
                    if (cD.equals("Y") || cD.equals("y") || Objects.equals(cD, "yes") || Objects.equals(cD, "Yes")) {
                        compDice = true;
                    } else {
                        compDice = false;
                    }
                } else {
                    System.out.println("please enter yes or no (Y/N)");
                }
            }


            pla = new Player();
            pla.setPlayerName(t);
            pla.setPlayerPOS(1);
            pla.setCompDice(compDice);
            players.add(pla);


        }


    }

    /**
     * @return : Returns players.
     */
    public List<Player> returnPlayers() {
        return players;
    }

    /**
     * This method fetches the desired board size from the user.
     */
    public void board() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the dimensions of the board (3-4 no wormholes, 5-10 with wormholes)");
            boarddimensions = sc.nextInt();
            if (boarddimensions >= 3 && boarddimensions <= 10) {
                valid = true;
            } else {
                System.out.println("Please enter a number between 3-10");
            }
        }
        System.out.println("The board size will be " + boarddimensions * boarddimensions);
    }

    /**
     * @return : Returns the board dimensions.
     */
    public int fetchboardsize() {
        return boarddimensions;
    }

    /**
     * @return : Returns the player amount for test.
     */
    public int playerNum() {
        playernumber = (2 | 3 | 4 | 5 | 6);
        return (playernumber);}

    /**
     * @return : Returns the board dimensions for test.
     */
    public int boarddimeninebynine() {
        boarddimensions = 9;
        return (boarddimensions * boarddimensions);
    }
}


