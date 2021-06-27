package me.tkuipers.interview.arterys;


import me.tkuipers.interview.arterys.evaluation.GameEvaluator;
import me.tkuipers.interview.arterys.input.StandardInputReader;
import me.tkuipers.interview.arterys.log.Log;

import java.util.stream.Collectors;

public class ArterysMain {
    public static void main(String[] args) {
        var orderedPlayers = new GameEvaluator(new StandardInputReader()).evaluateGame();
        for(var i = 0; i < orderedPlayers.size(); i++) {
            System.out.println(i + " " +orderedPlayers.get(i));
        }
    }
}
