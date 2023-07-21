package com.gkonovalov.algorithms.gametheory.prisonersdilemma.players;


/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * Tit-for-Tat Player: The Tit-for-Tat character starts by cooperating in the first round and then
 * replicates the opponent's last move in each subsequent round.
 */
public class TitForTat extends Player {

    private boolean lastPlay = true;

    @Override
    public boolean getPlay() {
        return this.lastPlay;
    }

    @Override
    public void result(boolean result) {
        this.lastPlay = result;
    }

    @Override
    public String getPlayerName() {
        return "TitForTat";
    }
}

