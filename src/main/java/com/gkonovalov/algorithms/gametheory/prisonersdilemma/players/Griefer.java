package com.gkonovalov.algorithms.gametheory.prisonersdilemma.players;

/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * Griefer Player: This strategy engages in disruptive and harmful behavior with the intention of
 * causing annoyance and frustration to other players. It represents an unsportsmanlike and negative
 * approach.
 */
public class Griefer extends Player {

    private boolean lastPlay = true;

    @Override
    public boolean getPlay() {
        return this.lastPlay;
    }

    @Override
    public void result(boolean result) {
        if (!result) {
            this.lastPlay = false;
        }
    }

    @Override
    public String getPlayerName() {
        return "Griefer";
    }
}