package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;

public class ThreeOfAKindHandPreparer extends MappedCardHandPreparer {
    public ThreeOfAKindHandPreparer() {
        super(HandType.THREE_OF_A_KIND);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        List<Card> pair = null;
        List<Card> outOfHand = Lists.newArrayList();
        var isValid = false;
        if(this.map.asMap().size() == 3) {
            for (var key : this.map.asMap().keySet()) {
                if(this.map.get(key).size() == 3) {
                    pair = this.map.get(key);
                    isValid = true;
                }
                else{
                    outOfHand.addAll(this.map.get(key));
                }
            }
            if(isValid) {
                return new HandValidation(true, joinLists(pair, outOfHand), this.type);
            }
        }
        return new HandValidation(false);
    }
}
