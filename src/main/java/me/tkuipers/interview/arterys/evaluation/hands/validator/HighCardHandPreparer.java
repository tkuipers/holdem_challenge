package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

public class HighCardHandPreparer extends HandPreparer {
    public HighCardHandPreparer() {
        super(HandType.HIGH_CARD);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        return new HandValidation(true, hand, this.type);
    }
}
