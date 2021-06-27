package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StraightFlushHandPreparerTest {
    @Test
    public void normalSF() {
        var hand = Lists.newArrayList(Card.fromString("7H"), Card.fromString("3H"), Card.fromString("4H"),
                Card.fromString("5H"), Card.fromString("6H"));

        var validator = new StraightFlushHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.STRAIGHT_FLUSH, validator.getType());
        assertEquals(5, validator.getCards().size(), "Expected all cards to be in hand");
    }

    @Test
    public void royalStraight() {
        var hand = Lists.newArrayList(Card.fromString("9H"), Card.fromString("TD"), Card.fromString("JC"),
                Card.fromString("QS"), Card.fromString("KH"));

        var validator = new StraightFlushHandPreparer().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void normalFlush() {
        var hand = Lists.newArrayList(Card.fromString("9H"), Card.fromString("6H"), Card.fromString("JH"),
                Card.fromString("QH"), Card.fromString("KH"));

        var validator = new StraightFlushHandPreparer().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }
}
