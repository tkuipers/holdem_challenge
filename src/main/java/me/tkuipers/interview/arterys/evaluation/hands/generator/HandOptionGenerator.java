package me.tkuipers.interview.arterys.evaluation.hands.generator;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandValidation;

import java.util.LinkedList;
import java.util.List;

public class HandOptionGenerator {
    private ImmutableList<Card> cards;
    private static final int HAND_SIZE = 5;
    private List<List<Card>> possibleHands;

    public HandOptionGenerator(List<Card> cards) {
        this.cards = ImmutableList.copyOf(cards);
        possibleHands = Lists.newArrayList();
    }

    private void genCombos(int first, LinkedList<Card> curr) {
        if(curr.size() == HAND_SIZE) {
            possibleHands.add(Lists.newArrayList(curr));
        }

        for(int i = first; i < cards.size(); i++){
            curr.add(cards.get(i));

            genCombos(i+1, curr);

            curr.removeLast();
        }
    }

    public List<List<Card>> combine(){
        if(this.possibleHands.isEmpty()) {
            this.genCombos(0, Lists.newLinkedList());
        }
        return this.possibleHands;
    }
}
