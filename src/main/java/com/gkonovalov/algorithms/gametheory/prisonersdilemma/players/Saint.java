package com.gkonovalov.algorithms.gametheory.prisonersdilemma.players;

/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * Saint Player: he Saint player represents an altruistic and cooperative approach, where
 * it always chooses to cooperate regardless of the opponent's action.
 */
public class Saint extends Player {

    @Override
    public boolean getPlay() {
        return true;
    }

    @Override
    public String getPlayerName() {
        return "Saint";
    }
}
