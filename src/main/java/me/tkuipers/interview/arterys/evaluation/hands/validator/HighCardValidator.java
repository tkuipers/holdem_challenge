package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

public class HighCardValidator extends Validator{
    public HighCardValidator() {
        super(HandType.HIGH_CARD);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        return new HandValidation(true, hand, Lists.newArrayList(), this.type);
    }
}