package me.tkuipers.interview.arterys.evaluation.hands;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.Comparator;
import java.util.List;

public class HandValidationComparer implements Comparator<HandValidation> {
    private boolean shouldDetermineKickerDisplay;
    public HandValidationComparer(boolean shouldDetermineKickerDisplay) {
        this.shouldDetermineKickerDisplay = shouldDetermineKickerDisplay;
    }

    @Override
    public int compare(HandValidation o1, HandValidation o2) {
        return -1 * compareAscending(o1, o2);
    }

    //returns - number if o1 is smaller,positive if bigger, and 0 if equal
    public int compareAscending(HandValidation o1, HandValidation o2) {
        //Check for higher hand value
        if(o1.getType() == o2.getType()){
            //compare hands directly
            int handDiff = new HandComparer(true).compare(o1, o2);
            if(handDiff != 0){
                return handDiff;
            }
            //compare kickers
            //Determine whether they should be displayed.
            if(shouldDetermineKickerDisplay){
                o1.setKickerMatters(true);
                o2.setKickerMatters(true);
            }
            return new HandComparer(false).compare(o1, o2);
        }
        else{
            return Integer.compare(o1.getType().getValue(), o2.getType().getValue());
        }
    }



    //Return the larger hand if possible, else sort and return the one with first higher value
    private class HandComparer implements Comparator<HandValidation> {
        private final boolean compareInHand;
        public HandComparer(boolean compareInHand) {
            this.compareInHand = compareInHand;
        }

        @Override
        public int compare(HandValidation h1, HandValidation h2) {
            List<Card> o1 = compareInHand ? h1.getInHandCards() : h1.getOutOfHandCards();
            List<Card> o2 = compareInHand ? h2.getInHandCards() : h2.getOutOfHandCards();
            if(o1.size() != o2.size()){
                return Integer.compare(o1.size(), o2.size());
            }
            o1 = Lists.newArrayList(o1);
            o2 = Lists.newArrayList(o2);
            o1.sort(Comparator.comparingInt(Card::getValue));
            o2.sort(Comparator.comparingInt(Card::getValue));

            if(!o1.isEmpty() && h1.isLowWheel()){
                var el = o1.remove(o1.size()-1);
                o1.add(0, el);
            }

            if(!o2.isEmpty() && h2.isLowWheel()){
                var el = o2.remove(o2.size()-1);
                o2.add(0, el);
            }

            for(int i = o1.size()-1; i >= 0; i--){
                var val1 = o1.get(i).getValue();
                var val2 = o2.get(i).getValue();

                if(val1 != val2) {
                    return Integer.compare(val1, val2);
                }
            }
            return 0;
        }
    }
}
