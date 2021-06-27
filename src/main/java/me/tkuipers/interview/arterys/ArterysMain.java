package me.tkuipers.interview.arterys;


import me.tkuipers.interview.arterys.evaluation.GameEvaluator;
import me.tkuipers.interview.arterys.input.StandardInputReader;

import java.util.stream.Collectors;

public class ArterysMain {
    public static void main(String[] args) {
        //Add Comments
        //Re-Eval Architecture, especially around kicker and printing
        //Add Logging
        //Add Docker
        //run through sonarqube and linter
        //commit to git
        var orderedPlayers = new GameEvaluator(new StandardInputReader()).evaluateGame();
        System.out.println(orderedPlayers.stream().collect(Collectors.joining("\n")));
    }
}
