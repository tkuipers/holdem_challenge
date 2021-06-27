package me.tkuipers.interview.arterys.evaluation.hands.validator;

import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

public class RoyalFlushValidator extends SameSuiteValidator{
    public RoyalFlushValidator() {
        super(HandType.ROYAL_FLUSH);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        var mightBeValid = new StraightFlushValidator().evaluateHand(hand);
        if(mightBeValid.isValid() && hand.get(0).getValue() == 8) {
            mightBeValid.setType(this.type);
            return mightBeValid;
        }
        return new HandValidation(false);
    }
}
