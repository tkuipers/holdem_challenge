package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.Comparator;
import java.util.List;

public abstract class SameSuiteValidator extends Validator{
    protected SameSuiteValidator(HandType type){
        super(type);
    }

    public HandValidation evaluateHand(List<Card> hand) {
        hand = Lists.newArrayList(hand);
        if(super.validateHand(hand)){
            var suit = hand.get(0).getSuit();
            if(hand.stream().allMatch(c -> c.getSuit() == suit)) {
                hand.sort(Comparator.comparingInt(Card::getValue));
                return evaluate(hand);
            }
        }
        return new HandValidation(false);
    }
}
