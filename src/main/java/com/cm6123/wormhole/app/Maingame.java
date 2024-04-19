package com.cm6123.wormhole.app;

import com.cm6123.wormhole.dice.Dice;

import java.util.List;
import java.util.Scanner;

/**
 * This class is where the main scenarios of the game fall into place.
 */
public class Maingame {
    /**
     *This makes an object for the class 'Board'.
     */
    private Board       cb = new Board();

    /**
     *This method starts the actual game itself.
     */
    public void sUgame() {
        Scanner sc = new Scanner(System.in);
        cb.boardSetup();
        boolean win = false;
        Dice die = new Dice(6);
        Gamestartup gsu = new Gamestartup();
        int x = cb.fetchboardsize();
        int condition2Win = x * x;
        gsu.fetchplayers();
        List playerList = gsu.returnPlayers();
        while (!win) {
            for (int i = 0; i < playerList.size(); i++) {
                int roll;
                Player pl = new Player();
                pl = (Player) playerList.get(i);
                int pP = pl.fetchPlayerPOS();
                System.out.println("its " + pl.fetchPlayerName() + "s turn!");
                System.out.println(pl.fetchPlayerName() + "s position is " + pP);
                roll = 0;
                if (!pl.fetchCompDice()) {
                    int roll1 = die.roll();
                    System.out.println("You rolled a " + roll1);
                    int roll2 = die.roll();
                    System.out.print("You rolled a " + roll2 + "\r\n");
                    roll = roll1 + roll2;
                } else {
                    System.out.println("What did you roll?");
                    roll = sc.nextInt();
                }
                if (pP + roll >= condition2Win) {
                    win = true;
                    System.out.print("the winner is: " + pl.fetchPlayerName());
                    break;
                } else {
                    movement(pl, roll, cb.fetchboardsize());
                }

            }
        }


    }

    /**
     *@param boardDIME includes a parameter for the board dimensions.
     *@param dicePOS Includes parameter for the dice position.
     *@param pla Includes parameter for the player.
     */
    public void movement(final Player pla, final int dicePOS, final int boardDIME) {
        String[][] board = cb.getBoard();
        boolean breakloop = false;
        int newPOS = pla.fetchPlayerPOS() + dicePOS;
        String currentPOS = String.valueOf(newPOS);
        for (int i = 0; i < boardDIME; i++) {
            for (int j = 0; j < boardDIME; j++) {
                String boardTXT = board[i][j];
                if (boardTXT.contains(currentPOS)) {
                    if (boardTXT.contains("positive")) {
                        int y = 0;
                        for (int ii = i; ii < boardDIME; ii++) {
                            for (int jj = j; jj < boardDIME; jj++) {
                                String boardcontains = board[ii][jj];
                                if (boardcontains.contains("exit")) {
                                    String intDATA = boardcontains.replaceAll("\\D+", "");
                                    y = Integer.valueOf(intDATA);
                                    System.out.println("Wormhole! Moving to: " + intDATA);
                                    pla.setPlayerPOS(y);
                                    breakloop = true;
                                    break;
                                }
                            }
                            if (breakloop) {
                                break;
                            }
                        }


                    } else if (boardTXT.contains("negative")) {
                        int y = 0;
                        System.out.println("the board text is " + boardTXT);
                        for (int ii = i; ii > -1; ii--) {
                            for (int jj = j; jj > -1; jj--) {
                                String boardcontains = board[ii][jj];
                                if (boardcontains.contains("exit")) {
                                    String intValue = boardcontains.replaceAll("\\D+", "");
                                    y = Integer.valueOf(intValue);
                                    System.out.println("Wormhole! Moving to: " + intValue);
                                    pla.setPlayerPOS(y);
                                    breakloop = true;
                                    break;
                                }
                            }
                            j = boardDIME - 1;
                            if (breakloop) {
                                break;
                            }
                        }


                    } else {
                        String intData = boardTXT.replaceAll("\\D+", "");
                        int y = Integer.valueOf(intData);
                        pla.setPlayerPOS(y);
                        breakloop = true;
                        break;

                    }
                }
                if (breakloop) {
                    break;
                }
            }

            if (breakloop) {
                break;
            }
        }
    }
}
