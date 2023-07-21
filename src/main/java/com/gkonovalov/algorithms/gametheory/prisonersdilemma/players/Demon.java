package com.gkonovalov.algorithms.gametheory.prisonersdilemma.players;


/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * Demon Player: A character that never cooperates and always defects in the game. This player
 * always chooses the option that is most beneficial for themselves without considering the
 * consequences for others.
 */
public class Demon extends Player {

    @Override
    public boolean getPlay() {
        return false;
    }

    @Override
    public String getPlayerName() {
        return "Demon";
    }
}