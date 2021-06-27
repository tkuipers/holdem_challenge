package me.tkuipers.interview.arterys.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardParserTest {
    @Test
    public void simpleCase() {
        var card = Card.fromString("2H");

        Assertions.assertEquals(0, card.getValue());
        Assertions.assertEquals(Suit.HEARTS, card.getSuit());
    }

    @Test
    public void faceValue() {
        var card = Card.fromString("KD");

        Assertions.assertEquals(11, card.getValue());
        Assertions.assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    public void invalidValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Card.fromString("FD");
        });
    }

    @Test
    public void invalidSuit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Card.fromString("5O");
        });
    }

}
