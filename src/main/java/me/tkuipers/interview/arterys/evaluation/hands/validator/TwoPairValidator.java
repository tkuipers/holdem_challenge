package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;
import java.util.stream.Collectors;

public class TwoPairValidator extends MappedCardValidator{
    public TwoPairValidator() {
        super(HandType.TWO_PAIR);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        List<List<Card>> pairs = Lists.newArrayList();
        List<Card> outOfHand = Lists.newArrayList();
        System.out.println("Here is what's in the map");
        System.out.println("\n" + this.map + "\n");
        for(var key : this.map.asMap().keySet()) {
            if(this.map.asMap().get(key).size() == 2) {
                System.out.println("Adding to list");
                System.out.println(this.map.get(key));
                pairs.add(this.map.get(key));
            }
            else{
                outOfHand.addAll(this.map.get(key));
            }
        }
        if(pairs.size() == 2){
            return new HandValidation(true, pairs.stream().flatMap(List::stream).collect(Collectors.toList()), outOfHand, this.type);
        }
        return new HandValidation(false);
    }
}
