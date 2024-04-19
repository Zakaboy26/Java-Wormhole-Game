package com.cm6123.wormhole.app;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GamestartupTest {
    @Test
    @DisplayName("The board should have 81 squares when the user enters 9 for the dimensions")
    public void checkBoardDimension() throws Exception {
        Gamestartup boardDIMETEST = new Gamestartup();
        int size = boardDIMETEST.boarddimeninebynine();
        assertEquals(size,81);
    }

    @Test
    @DisplayName("Tests if correct amount of players able to play the game")
    public void checkProperPlayersize() throws Exception {
        Gamestartup boardSIZETEST = new Gamestartup();
        int size = boardSIZETEST.playerNum();
        assertEquals(size,2 | 3 | 4 | 5 | 6);
    }
}