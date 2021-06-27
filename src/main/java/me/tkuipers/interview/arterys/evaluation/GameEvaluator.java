package me.tkuipers.interview.arterys.evaluation;

import me.tkuipers.interview.arterys.evaluation.engine.EvaluationEngine;
import me.tkuipers.interview.arterys.evaluation.hands.HandValidationComparer;
import me.tkuipers.interview.arterys.input.InputReader;
import me.tkuipers.interview.arterys.input.StandardInputReader;

import java.util.List;
import java.util.stream.Collectors;

public class GameEvaluator {
    private InputReader reader;

    public GameEvaluator(InputReader reader) {
        this.reader = reader;
    }

    public List<String> evaluateGame() {
        var gameData = new CardParser(reader);
        var eval = new EvaluationEngine();
        var players = gameData.getPlayers();
        for(var player : players) {
            player.setBestHand(eval.evaluate(player));
        }

        players.sort((p1, p2) -> new HandValidationComparer(true).
                compare(p1.getBestHand(), p2.getBestHand()));

        return players.stream().map(p -> p.getOutputString()).collect(Collectors.toList());
    }
}
