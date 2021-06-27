package me.tkuipers.interview.arterys.evaluation.hands.validator;

import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;
import java.util.stream.Collectors;

public class FourOfAKindHandPreparer extends MappedCardHandPreparer {
    public FourOfAKindHandPreparer() {
        super(HandType.FOUR_OF_A_KIND);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        if(map.asMap().entrySet().size() == 2){
            var keys = map.asMap().keySet().stream().collect(Collectors.toList());
            if(map.asMap().get(keys.get(0)).size() == 4) {
                return new HandValidation(true,
                        joinLists(
                                map.asMap().get(keys.get(0)).stream().collect(Collectors.toList()),
                                map.asMap().get(keys.get(1)).stream().collect(Collectors.toList())),
                        this.type);
            }
            if(map.asMap().get(keys.get(0)).size() == 1) {
                return new HandValidation(true,
                        joinLists(
                                map.asMap().get(keys.get(1)).stream().collect(Collectors.toList()),
                                map.asMap().get(keys.get(0)).stream().collect(Collectors.toList())),
                        this.type);
            }
        }
        return new HandValidation(false);
    }
}
