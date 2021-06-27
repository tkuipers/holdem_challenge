package me.tkuipers.interview.arterys.evaluation.hands.display;

import com.google.common.collect.ImmutableList;
import me.tkuipers.interview.arterys.data.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HandFormattingTest {
    private static ImmutableList<Card> hand;

    @BeforeAll
    public static void instatiate() {
        hand = ImmutableList.of(
                Card.fromString("2S"),
                Card.fromString("4H"),
                Card.fromString("KS"),
                Card.fromString("AH"),
                Card.fromString("AD"));
    }

    @Test
    public void testUniqueDisplay() {
        var out = HandPrintingFormatters.UNIQUE_VALUES.getDescription(hand);

        Assertions.assertEquals("Ace King Four Two", out);
    }

    @Test
    public void testHighCardDisplay() {
        var out = HandPrintingFormatters.HIGH_CARD.getDescription(hand);

        Assertions.assertEquals("Ace", out);
    }

    @Test
    public void testDisplayNothing() {
        var out = HandPrintingFormatters.PRINT_NOTHING.getDescription(hand);

        Assertions.assertEquals("", out);
    }
}
