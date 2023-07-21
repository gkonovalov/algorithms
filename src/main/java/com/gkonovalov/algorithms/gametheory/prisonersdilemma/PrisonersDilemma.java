package com.gkonovalov.algorithms.gametheory.prisonersdilemma;

import com.gkonovalov.algorithms.gametheory.prisonersdilemma.players.*;

import java.util.List;

/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * The Prisoner's Dilemma is a classic problem in Game Theory that demonstrates the tension between
 * individual rationality and collective rationality. It involves multiple players with different
 * strategies (cooperate, betray, etc), leading to different outcomes and payoffs. The dilemma
 * arises from the conflict between what is best for an individual player and what is best for
 * both players collectively.
 *
 * In the context of the Prisoner's Dilemma, the payoff rules refer to the outcomes and
 * corresponding payoffs that each player receives based on their choices (cooperate or defect)
 * and the choices made by their opponent. These payoffs are typically represented in a payoff
 * matrix that shows the results for each combination of choices.
 *
 *                | B (Cooperate)  | B (Defect)
 * -------------------------------------------------------
 * A (Cooperate) | R (Reward)     |   S (Sucker's Payoff)
 * -------------------------------------------------------
 * A (Defect)   | T (Temptation) |   P (Punishment)
 *
 * In the Prisoner's Dilemma with multiple strategies, the players interact in a round-robin
 * tournament, where each player competes against all other players multiple times. The outcomes
 * of their interactions are recorded, and the scores or payoffs of each player are updated based
 * on the results of the games.
 */
public class PrisonersDilemma {

    public static void main(String[] args) {
        Tournament tournament = new Tournament(List.of(
                new TitForTat(),
                new Random(),
                new Saint(),
                new Demon(),
                new Griefer()
        ));
        tournament.play();
    }
}
