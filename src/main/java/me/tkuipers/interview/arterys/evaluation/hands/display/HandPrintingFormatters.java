package me.tkuipers.interview.arterys.evaluation.hands.display;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import me.tkuipers.interview.arterys.data.Card;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class HandPrintingFormatters {
    public static final HandPrintingFormatter HIGH_CARD = hand -> hand.get(hand.size()-1).getDescription();

    public static final HandPrintingFormatter UNIQUE_VALUES = hand -> {
        Set<Integer> uniqueCards = Sets.newHashSet();

        uniqueCards.addAll(hand.stream().map(c -> c.getValue()).collect(Collectors.toList()));

        return uniqueCards.stream().sorted((v1, v2) -> Integer.compare(v1, v2) *  -1).map(c -> Card.getFaceFromValue(c)).collect(Collectors.joining(" "));
    };

    public static final HandPrintingFormatter PRINT_NOTHING = hand -> "";
}
