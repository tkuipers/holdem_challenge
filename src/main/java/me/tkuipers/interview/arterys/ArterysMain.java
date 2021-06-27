package me.tkuipers.interview.arterys;


import me.tkuipers.interview.arterys.evaluation.GameEvaluator;
import me.tkuipers.interview.arterys.input.StandardInputReader;
import me.tkuipers.interview.arterys.log.Log;

import java.util.stream.Collectors;

public class ArterysMain {
    public static void main(String[] args) {
        //Add Comments
        //Re-Eval Architecture, especially around kicker and printing
        //run through sonarqube and linter
        var orderedPlayers = new GameEvaluator(new StandardInputReader()).evaluateGame();
        System.out.println(orderedPlayers.stream().collect(Collectors.joining("\n")));
    }
}
