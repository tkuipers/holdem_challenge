package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.Comparator;
import java.util.List;

public abstract class Validator {
    protected final HandType type;

    protected Validator(HandType type){
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

}
