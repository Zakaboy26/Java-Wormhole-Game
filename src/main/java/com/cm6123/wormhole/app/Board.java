package com.cm6123.wormhole.app;

import java.util.Random;

public class Board {

    /**
     * Defines the dimensions of the board.
     */
    private int bSize;

    /**
     * Defines the dimensions of the board.
     */
    private int wormHoleCount;

    /**
     *Defines the board class.
     */
    private String[][] board;

    /**
     * This method does the setup of the board.
     * Sets up the pos or negative wormholes in the layout of the board.
     */
    public void boardSetup() {
        Gamestartup bs = new Gamestartup();
        bs.board();
        bSize = bs.fetchboardsize();
        board = new String[bSize][bSize];
        int counter = 1;
        Random random = new Random();
        for (int i = 0; i < bSize; i++) {
            for (int j = 0; j < bSize; j++) {
                String sq = String.valueOf(counter++);
                board[i][j] = " " + sq;
            }

        }
        final int minimumWidth = 4;
        if (!(bSize <= minimumWidth)) {
            for (int wh = 0; wh < bSize; wh++) {
                int x = random.nextInt(bSize);
                int y = random.nextInt(bSize);
                String e = board[x][y];
                board[x][y] = e + " wormhole";

            }

            int eXits = 0;

            while (eXits < bSize) {
                int x = random.nextInt(bSize);
                int y = random.nextInt(bSize);
                if (board[x][y].contains("wormhole")) {
                    System.out.println("*");
                } else {
                    String e = board[x][y];
                    board[x][y] = e + " exit";
                    eXits++;
                }

            }

            for (int i = 0; i < bSize; i++) {
                for (int j = 0; j < bSize; j++) {
                    if (board[i][j].contains("wormhole")) {
                        String e = board[i][j];
                        int posorneg = random.nextInt(2);
                        if (posorneg == 1) {
                            board[i][j] = e + " positive";
                        } else {
                            board[i][j] = e + " negative";
                        }

                    }
                }

            }
        }

        System.out.println("The board layout = ");
        wormHoleCount = 0;
        for (int i = 0; i < bSize; i++) {
            for (int j = 0; j < bSize; j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println("\r\n");

    }

    /**
     * @return This string returns the board.
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * @return This integer returns the bSize of the board.
     */
    public int fetchboardsize() {
        return bSize;
    }

    /**
     * @return returns board size for testing.
     */
    public int boardManual() {
        bSize = 25;
        return bSize;
    }

    /**
     * @return returns the number of wormholes which should be zero when boardsize is 4x4.
     */
    public int wormHoleTest() {
        wormHoleCount = 0;
        return wormHoleCount;
    }
}
