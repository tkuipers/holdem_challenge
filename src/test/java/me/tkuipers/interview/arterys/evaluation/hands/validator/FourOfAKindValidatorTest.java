package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FourOfAKindValidatorTest {
    @Test
    public void fourAces() {
        var hand = Lists.newArrayList(Card.fromString("3H"), Card.fromString("AS"), Card.fromString("AC"),
                Card.fromString("AD"), Card.fromString("AH"));

        var validator = new FourOfAKindValidator().evaluateHand(hand);

        assertTrue(validator.isValid(), "Expected hand to be a valid hand: " + hand);
        assertEquals(HandType.FOUR_OF_A_KIND, validator.getType());
        assertEquals(4, validator.getInHandCards().size(), "Expected four cards to be in hand");
        assertEquals(1, validator.getOutOfHandCards().size(), "Expected 1 possible kicker");
    }

    @Test
    public void fourTwos() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("2C"),
                Card.fromString("2D"), Card.fromString("2H"));

        var validator = new FourOfAKindValidator().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(4, validator.getInHandCards().size(), "Expected four cards to be in hand");
        assertEquals(1, validator.getOutOfHandCards().size(), "Expected 1 possible kicker");
    }

    @Test
    public void fullHouse() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("2H"), Card.fromString("2C"),
                Card.fromString("3D"), Card.fromString("3H"));

        var validator = new FourOfAKindValidator().evaluateHand(hand);

        assertFalse(validator.isValid(), "Expected hand not to be valid: " + hand);
    }
}
