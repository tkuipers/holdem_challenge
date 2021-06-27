package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.ArrayListMultimap;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

public abstract class MappedCardHandPreparer extends HandPreparer {
    protected ArrayListMultimap<Integer, Card> map;

    protected MappedCardHandPreparer(HandType type){
        super(type);
        map = ArrayListMultimap.create();
    }

    public HandValidation evaluateHand(List<Card> hand){
        if(!validateHand(hand)){
            return new HandValidation(false);
        }
        insertIntoMap(hand);

        return evaluate(hand);
    }

    private void insertIntoMap(List<Card> hand) {
        for(var card : hand) {
            map.put(card.getValue(), card);
        }
    }
}
