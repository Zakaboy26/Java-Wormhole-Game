package com.cm6123.wormhole.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    @Test
    @DisplayName("if the user enters a board dimension of 5x5 it will be returned as 25")
    void checkmanBoard25() throws Exception {
    Board board = new Board();
    int size = board.boardManual();
    assertEquals(size, 25);
    }

    @Test
    @DisplayName("Makes sure there are no wormholes when a board dimension of 4 is given")
    void checkmanNoWormHoles() throws Exception {
        Board hole = new Board();
        int size = hole.wormHoleTest();
        assertEquals(size, 0);
    }
}
