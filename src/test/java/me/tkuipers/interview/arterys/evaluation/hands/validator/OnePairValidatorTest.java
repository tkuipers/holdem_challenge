package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnePairValidatorTest {
    @Test
    public void passCase() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("7C"),
                Card.fromString("6D"), Card.fromString("2H"));

        var validator = new OnePairValidator().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.ONE_PAIR, validator.getType());
        assertEquals(2, validator.getInHandCards().size(), "Expected two cards to be in hand");
        assertEquals(3, validator.getOutOfHandCards().size(), "Expected 3 possible kickers");
    }

    @Test
    public void threeOfAKind() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("7C"),
                Card.fromString("2D"), Card.fromString("2H"));

        var validator = new OnePairValidator().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void noPair() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("7C"),
                Card.fromString("9D"), Card.fromString("TH"));

        var validator = new OnePairValidator().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }
}
