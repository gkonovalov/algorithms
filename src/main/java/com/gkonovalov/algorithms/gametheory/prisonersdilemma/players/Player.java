package com.gkonovalov.algorithms.gametheory.prisonersdilemma.players;

/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * Abstract Player class.
 */
public abstract class Player {

    private int points;

    public Player() {
        this.points = 0;
    }

    public int getPoints() {
        return this.points;
    }

    public void updateScore(int points) {
        this.points += points;
    }

    public void result(boolean result) {}

    public abstract boolean getPlay();

    public abstract String getPlayerName();
}
