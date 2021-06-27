package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

public class StraightHandPreparer extends HandPreparer {
    public StraightHandPreparer() {
        super(HandType.STRAIGHT);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        var startingVal = hand.get(0).getValue();
        var couldBeWheel = hand.get(4).getValue() == 12 && hand.get(0).getValue() == 0;
        if(!couldBeWheel) {
            //General Case
            for (int i = 0; i < 5; i++) {
                if (hand.get(i).getValue() != (i + startingVal)) {
                    return new HandValidation(false);
                }
            }
            return new HandValidation(true, hand, this.type);
        }
        else {
            //Case where ace is played low
            for (int i = 0; i < 4; i++) {
                if (hand.get(i).getValue() != (i + startingVal)) {
                    return new HandValidation(false);
                }
            }
            moveAceToBeginning(hand);
            var validation = new HandValidation(true, hand, this.type);
            return validation;
        }
    }

    private void moveAceToBeginning(List<Card> hand) {
        var el = hand.remove(hand.size()-1);
        hand.add(0, el);
    }
}
