package com.gkonovalov.algorithms.gametheory.prisonersdilemma.players;

/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * Random Player:  The Random player does not follow a specific pattern or strategy but
 * instead makes decisions by chance.
 */
public class Random extends Player {

    @Override
    public boolean getPlay() {
        return Math.random() > 0.5;
    }

    @Override
    public String getPlayerName() {
        return "Random";
    }
}
