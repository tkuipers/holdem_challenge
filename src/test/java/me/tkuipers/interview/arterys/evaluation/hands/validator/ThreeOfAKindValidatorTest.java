package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeOfAKindValidatorTest {
    @Test
    public void passCase() {
        var hand = Lists.newArrayList(Card.fromString("4H"), Card.fromString("5D"), Card.fromString("6C"),
                Card.fromString("4S"), Card.fromString("4D"));

        var validator = new ThreeOfAKindValidator().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.THREE_OF_A_KIND, validator.getType());
        assertEquals(3, validator.getInHandCards().size(), "Expected 3 cards to be in hand");
        assertEquals(2, validator.getOutOfHandCards().size(), "Expected 2 cards to be in hand");
    }

    @Test
    public void twoPairCase() {
        var hand = Lists.newArrayList(Card.fromString("4H"), Card.fromString("5D"), Card.fromString("6C"),
                Card.fromString("4S"), Card.fromString("5C"));

        var validator = new ThreeOfAKindValidator().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void noDuplicateCase() {
        var hand = Lists.newArrayList(Card.fromString("4H"), Card.fromString("5D"), Card.fromString("6C"),
                Card.fromString("7S"), Card.fromString("8C"));

        var validator = new ThreeOfAKindValidator().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }
}
