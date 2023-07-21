package com.gkonovalov.algorithms.gametheory.prisonersdilemma;

import com.gkonovalov.algorithms.gametheory.prisonersdilemma.players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Georgiy Konovalov on 21/07/2023.
 * <p>
 * In the Prisoner's Dilemma with multiple strategies, the players interact in a round-robin
 * tournament, where each player competes against all other players multiple times. The outcomes
 * of their interactions are recorded, and the scores or payoffs of each player are updated based
 * on the results of the games.
 */
public class Tournament {

    private ArrayList<Player> players;
    private Map<String, Float> scores;

    public static final int REWARD = 2;
    public static final int SUCKER = -1;
    public static final int TEMPTATION = 3;
    public static final int PUNISHMENT = 0;

    public Tournament(List<Player> players) {
        this.players = new ArrayList<>(players);
        this.scores = new HashMap<>();

        for (Player p : players) {
            scores.put(p.getPlayerName(), 0f);
        }
    }

    public void play() {
        for (int p1 = 0; p1 < players.size(); p1++) {
            for (int p2 = p1 + 1; p2 < players.size(); p2++) {
                for (int round = 0; round < 10; round++) {
                    playRound(p1, p2);
                }
                updateScores();
            }
        }
        displayScores();
    }

    private void updateScores() {
        for (Player p : players) {
            float newScore = scores.getOrDefault(p.getPlayerName(), 0f) + p.getPoints();
            scores.put(p.getPlayerName(), newScore);
        }
    }

    private void playRound(int p1, int p2) {
        boolean player1 = players.get(p1).getPlay();
        boolean player2 = players.get(p2).getPlay();

        players.get(p1).result(player2);
        players.get(p2).result(player1);

        if (player1 && player2) {
            players.get(p1).updateScore(REWARD);
            players.get(p2).updateScore(REWARD);
        } else if (!player1 && !player2) {
            players.get(p1).updateScore(PUNISHMENT);
            players.get(p2).updateScore(PUNISHMENT);
        } else if (player1) {
            players.get(p1).updateScore(SUCKER);
            players.get(p2).updateScore(TEMPTATION);
        } else {
            players.get(p1).updateScore(TEMPTATION);
            players.get(p2).updateScore(SUCKER);
        }
    }

    private void displayScores() {
        System.out.println("Tournament results:");

        for (Player player : players) {
            System.out.println(player.getPlayerName() + ":  " + scores.get(player.getPlayerName()));
        }
    }
}
