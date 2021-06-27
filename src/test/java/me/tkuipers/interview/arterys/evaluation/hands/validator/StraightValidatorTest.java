package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//case where hand is 2 pair ACE/2 and other is 2Pair K/Q.
public class StraightValidatorTest {
    @Test
    public void passCase() {
        var hand = Lists.newArrayList(Card.fromString("4H"), Card.fromString("5D"), Card.fromString("6C"),
                Card.fromString("8S"), Card.fromString("7H"));

        var validator = new StraightValidator().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.STRAIGHT, validator.getType());
        assertEquals(5, validator.getInHandCards().size(), "Expected all cards to be in hand");
    }

    @Test
    public void wheelCase() {
        var hand = Lists.newArrayList(Card.fromString("2H"), Card.fromString("5D"), Card.fromString("4C"),
                Card.fromString("AS"), Card.fromString("3H"));

        var validator = new StraightValidator().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.STRAIGHT, validator.getType());
        assertEquals(5, validator.getInHandCards().size(), "Expected all cards to be in hand");
        assertTrue(validator.isLowWheel());
    }

    @Test
    public void pairInstead() {
        var hand = Lists.newArrayList(Card.fromString("2H"), Card.fromString("3D"), Card.fromString("5C"),
                Card.fromString("7S"), Card.fromString("7H"));

        var validator = new StraightValidator().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void noPair() {
        var hand = Lists.newArrayList(Card.fromString("2H"), Card.fromString("7D"), Card.fromString("8C"),
                Card.fromString("AS"), Card.fromString("TH"));

        var validator = new StraightValidator().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }
}
