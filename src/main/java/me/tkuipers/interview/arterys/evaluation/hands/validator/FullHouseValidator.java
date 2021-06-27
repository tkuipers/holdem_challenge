package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.List;
import java.util.stream.Collectors;

public class FullHouseValidator extends MappedCardValidator{
    public FullHouseValidator() {
        super(HandType.FULL_HOUSE);
    }

    @Override
    protected HandValidation evaluate(List<Card> hand) {
        if(map.asMap().entrySet().size() == 2){
            var keys = map.asMap().keySet().stream().collect(Collectors.toList());
            if(map.asMap().get(keys.get(0)).size() == 3 || map.asMap().get(keys.get(1)).size() == 3) {
                return new HandValidation(true, hand, Lists.newArrayList(), this.type);
            }
        }
        return new HandValidation(false);
    }
}
