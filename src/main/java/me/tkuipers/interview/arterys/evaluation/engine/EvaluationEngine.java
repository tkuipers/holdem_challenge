package me.tkuipers.interview.arterys.evaluation.engine;

import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandValidation;
import me.tkuipers.interview.arterys.data.Player;
import me.tkuipers.interview.arterys.evaluation.hands.HandValidationComparer;
import me.tkuipers.interview.arterys.evaluation.hands.validator.*;

import java.util.Collection;
import java.util.List;

public class EvaluationEngine {
    private Collection<Validator> validators;

    public HandValidation evaluate(Player player) {
        HandValidation bestHand = null;
        for(var hand : player.getHands()) {
            addValidators();
            var thisHand = evaluateHand(hand);
            if(thisHand.isValid()) {
                if(bestHand == null){
                    bestHand = thisHand;
                    continue;
                }
                if(new HandValidationComparer(false).compareAscending(thisHand, bestHand) > 0) {
                    bestHand = thisHand;
                }
            }
        }
        return bestHand;
    }

    private void addValidators() {
        this.validators = List.of(
                new RoyalFlushValidator(),
                new StraightFlushValidator(),
                new FourOfAKindValidator(),
                new FullHouseValidator(),
                new FlushValidator(),
                new StraightValidator(),
                new ThreeOfAKindValidator(),
                new TwoPairValidator(),
                new OnePairValidator(),
                new HighCardValidator()
        );
    }

    private HandValidation evaluateHand(List<Card> hand) {
        for(var validator : this.validators) {
            var handValidation = validator.evaluateHand(hand);
            if(handValidation.isValid()) {
                return handValidation;
            }
        }
        throw new IllegalArgumentException("Unable to validate hand: " + hand);
    }
}
