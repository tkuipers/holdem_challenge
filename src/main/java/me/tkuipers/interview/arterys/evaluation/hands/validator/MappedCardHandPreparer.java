package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.ArrayListMultimap;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

/**
 * Add all the cards to a hashmap and then prepare for evaluation and printing.
 */
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
