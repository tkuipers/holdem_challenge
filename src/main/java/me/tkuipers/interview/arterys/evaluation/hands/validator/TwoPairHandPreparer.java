package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;
import java.util.stream.Collectors;

public class TwoPairHandPreparer extends MappedCardHandPreparer {
    public TwoPairHandPreparer() {
        super(HandType.TWO_PAIR);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        List<List<Card>> pairs = Lists.newArrayList();
        List<Card> outOfHand = Lists.newArrayList();
        for(var key : this.map.asMap().keySet()) {
            if(this.map.asMap().get(key).size() == 2) {
                pairs.add(this.map.get(key));
            }
            else{
                outOfHand.addAll(this.map.get(key));
            }
        }
        if(pairs.size() == 2){
            return new HandValidation(true,
                    joinLists(pairs.stream().flatMap(List::stream).collect(Collectors.toList()), outOfHand),
                    this.type);
        }
        return new HandValidation(false);
    }
}
