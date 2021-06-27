package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoyalFlushHandPreparerTest {
    @Test
    public void heartRF() {
        var hand = Lists.newArrayList(Card.fromString("KH"), Card.fromString("TH"), Card.fromString("JH"),
                Card.fromString("QH"), Card.fromString("AH"));

        var validator = new RoyalFlushHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.ROYAL_FLUSH, validator.getType());
        assertEquals(5, validator.getCards().size(), "Expected all cards to be in hand");
    }

    @Test
    public void royalStraight() {
        var hand = Lists.newArrayList(Card.fromString("9H"), Card.fromString("TD"), Card.fromString("JC"),
                Card.fromString("QS"), Card.fromString("KH"));

        var validator = new RoyalFlushHandPreparer().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void normalFlush() {
        var hand = Lists.newArrayList(Card.fromString("9H"), Card.fromString("6H"), Card.fromString("JH"),
                Card.fromString("QH"), Card.fromString("KH"));

        var validator = new RoyalFlushHandPreparer().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }
}
