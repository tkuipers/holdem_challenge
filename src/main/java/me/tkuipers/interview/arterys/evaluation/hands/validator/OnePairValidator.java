package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import javax.print.attribute.HashDocAttributeSet;
import java.util.List;

public class OnePairValidator extends MappedCardValidator{
    public OnePairValidator() {
        super(HandType.ONE_PAIR);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        List<Card> pair = null;
        List<Card> outOfHand = Lists.newArrayList();
        var isValid = false;
        if(this.map.asMap().size() == 4) {
            for (var key : this.map.asMap().keySet()) {
                if(this.map.get(key).size() == 2) {
                    pair = this.map.get(key);
                    isValid = true;
                }
                else{
                    outOfHand.addAll(this.map.get(key));
                }
            }
            if(isValid) {
                return new HandValidation(true, pair, outOfHand, this.type);
            }
        }
        return new HandValidation(false);
    }
}
