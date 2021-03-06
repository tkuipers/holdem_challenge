package me.tkuipers.interview.arterys.evaluation.hands.display;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import me.tkuipers.interview.arterys.data.Card;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Concrete implementation for card printing
 */
public class HandPrintingFormatters {
    /**
     * Print the highest card in the hand
     */
    public static final HandPrintingFormatter HIGH_CARD = validation -> validation.getCards().get(validation.getCards().size()-1).getDescription();

    /**
     * Print all unique cards within the hand
     */
    public static final HandPrintingFormatter UNIQUE_VALUES = validation -> {
        var hand = validation.getCards().subList(5-validation.getType().getHandSize(), validation.getCards().size()-1);
        Set<Integer> uniqueCards = Sets.newHashSet();

        uniqueCards.addAll(hand.stream().map(c -> c.getValue()).collect(Collectors.toList()));

        return uniqueCards.stream().sorted((v1, v2) -> Integer.compare(v1, v2) *  -1).map(c -> Card.getFaceFromValue(c))
                .collect(Collectors.joining(" "));
    };

    /**
     * Don't print anything.
     */
    public static final HandPrintingFormatter PRINT_NOTHING = hand -> "";
}
