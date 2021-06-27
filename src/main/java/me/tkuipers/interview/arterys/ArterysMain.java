package me.tkuipers.interview.arterys;


import me.tkuipers.interview.arterys.evaluation.GameEvaluator;
import me.tkuipers.interview.arterys.input.StandardInputReader;
import me.tkuipers.interview.arterys.log.Log;

import java.util.stream.Collectors;

public class ArterysMain {
    public static void main(String[] args) {
        var orderedPlayers = new GameEvaluator(new StandardInputReader()).evaluateGame();
        System.out.println(orderedPlayers.stream().collect(Collectors.joining("\n")));
    }
}
