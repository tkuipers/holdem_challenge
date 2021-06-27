package me.tkuipers.interview.arterys.evaluation.hands;

import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.Comparator;
import java.util.List;

/**
 * Comparator for a HandValidation
 *
 * Compares by:
 * Hand Type
 * Cards that are part of the hand
 * Kickers
 */
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
            int handDiff = new HandComparer(shouldDetermineKickerDisplay).compare(o1, o2);
            return handDiff;
        }
        else{
            return Integer.compare(o1.getType().getValue(), o2.getType().getValue());
        }
    }

    //Expect hand to be prepared
    private class HandComparer implements Comparator<HandValidation> {

        private final boolean shouldEvaluateKicker;

        public HandComparer(boolean shouldDetermineKickerDisplay) {
            shouldEvaluateKicker = shouldDetermineKickerDisplay;
        }

        @Override
        public int compare(HandValidation h1, HandValidation h2) {
            List<Card> o1 = h1.getCards();
            List<Card> o2 = h2.getCards();
            //Compare starting at back end as that is where in-hand cards are stored.
            for(int i = o1.size()-1; i >= 0; i--){
                var val1 = o1.get(i).getValue();
                var val2 = o2.get(i).getValue();

                if(val1 != val2) {
                    if(shouldEvaluateKicker) {
                        addToKickers(h1, h2, o1, o2, i);
                    }
                    return Integer.compare(val1, val2);
                }
            }
            return 0;
        }
    }

    private void addToKickers(HandValidation h1, HandValidation h2, List<Card> o1, List<Card> o2, int i) {
        //determine if card is a possible kicker and if so, add it to list of useful kickers.
        if(i < o1.size()- h1.getType().getHandSize()){
            h1.addKicker(o1.get(i));
        }
        if(i < o2.size()- h2.getType().getHandSize()){
            h2.addKicker(o2.get(i));
        }
    }
}
