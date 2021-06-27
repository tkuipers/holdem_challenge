package me.tkuipers.interview.arterys.evaluation.hands.validator;

import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

public class StraightFlushValidator extends SameSuiteValidator{
    public StraightFlushValidator() {
        super(HandType.STRAIGHT_FLUSH);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        var valid = new StraightValidator().evaluateHand(hand);
        valid.setType(this.type);
        return valid;
    }
}
