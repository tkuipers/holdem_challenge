package me.tkuipers.interview.arterys.evaluation.engine;

import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandValidation;
import me.tkuipers.interview.arterys.data.Player;
import me.tkuipers.interview.arterys.evaluation.CardParser;
import me.tkuipers.interview.arterys.evaluation.hands.HandValidationComparer;
import me.tkuipers.interview.arterys.evaluation.hands.validator.*;
import me.tkuipers.interview.arterys.log.Log;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * The engine for evaluating the best hand that a player can have.  Uses all possible hands
 * for each player to determine which has the highest poker value.
 */
public class EvaluationEngine {
    private static final Logger LOG = Log.getLogger(CardParser.class.getSimpleName());
    private Collection<HandPreparer> handPreparers;

    public HandValidation evaluate(Player player) {
        HandValidation bestHand = null;
        LOG.info("Beginning Evaluation of: " + player.getName());
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
        LOG.info("Evaluated " + player.getName() + " Best Hand: " + bestHand.getHandDescription());
        return bestHand;
    }

    private void addValidators() {
        this.handPreparers = List.of(
                new RoyalFlushHandPreparer(),
                new StraightFlushHandPreparer(),
                new FourOfAKindHandPreparer(),
                new FullHouseHandPreparer(),
                new FlushHandPreparer(),
                new StraightHandPreparer(),
                new ThreeOfAKindHandPreparer(),
                new TwoPairHandPreparer(),
                new OnePairHandPreparer(),
                new HighCardHandPreparer()
        );
    }

    private HandValidation evaluateHand(List<Card> hand) {
        for(var validator : this.handPreparers) {
            LOG.fine("\tChecking hand for: " + validator.getType() + " hand: " + hand);
            var handValidation = validator.evaluateHand(hand);
            if(handValidation.isValid()) {
                return handValidation;
            }
        }
        throw new IllegalArgumentException("Unable to validate hand: " + hand);
    }
}
