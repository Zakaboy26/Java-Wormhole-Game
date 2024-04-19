package com.cm6123.wormhole.app ;

/**
 *This is where information about the players are stored.
 */
class Player {
    /**
     *This boolean defines the computer dice.
     */
    private boolean compDice;

    /**
     *This integer defines the player's position.
     */
    private int playerPos;

    /**
     *This String defines the player's name.
     */
    private String playerName;

    /**
     *@return This String returns the value of the player name (playername).
     */
    public String fetchPlayerName() {
        return playerName;
    }
    public boolean fetchCompDice() {
        return compDice;
    }

    public void setCompDice(final boolean compDICE) {
        this.compDice = compDICE;
    }
    public void setPlayerName(final String playerNAME) {
        this.playerName = playerNAME;
    }

    /**
     *@return This integer returns the value of the player position (playerPos).
     */
    public int fetchPlayerPOS() {
        return playerPos;
    }

    public void setPlayerPOS(final int playerPOS) {
        this.playerPos = playerPOS;
    }
}
