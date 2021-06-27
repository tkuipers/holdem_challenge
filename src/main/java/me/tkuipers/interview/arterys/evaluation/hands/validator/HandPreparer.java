package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Prepare a hand to be evaluated and printed.
 */
public abstract class HandPreparer {
    protected final HandType type;

    protected HandPreparer(HandType type){
        this.type = type;
    }

    public HandValidation evaluateHand(List<Card> hand){
        hand = Lists.newArrayList(hand);
        if(!validateHand(hand)){
            return new HandValidation(false);
        }

        hand.sort(Comparator.comparingInt(Card::getValue));

        return evaluate(hand);
    }

    protected final boolean validateHand(List<Card> hand) {
        return hand != null &&
                hand.size() == 5;
    }

    protected abstract HandValidation evaluate(List<Card> hand);

    public HandType getType() {
        return type;
    }

    protected List<Card> joinLists(List<Card> inHand, List<Card> outOfhand){
        return Stream.concat(outOfhand.stream(), inHand.stream())
                .collect(Collectors.toList());
    }

}
