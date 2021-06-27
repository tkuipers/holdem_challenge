package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighCardHandPreparerTest {
    @Test
    public void highKing() {
        var hand = Lists.newArrayList(Card.fromString("6S"), Card.fromString("8S"), Card.fromString("7C"),
                Card.fromString("2D"), Card.fromString("KH"));

        var validator = new HighCardHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.HIGH_CARD, validator.getType());
        assertEquals(5, validator.getCards().size(), "Expected five cards to be in hand");
    }

    @Test
    public void highAce() {
        var hand = Lists.newArrayList(Card.fromString("6S"), Card.fromString("AS"), Card.fromString("7C"),
                Card.fromString("2D"), Card.fromString("KH"));

        var validator = new HighCardHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(5, validator.getCards().size(), "Expected five cards to be in hand");
    }

    @Test
    public void FourOfAKind() {
        var hand = Lists.newArrayList(Card.fromString("6S"), Card.fromString("6H"), Card.fromString("6C"),
                Card.fromString("6D"), Card.fromString("KH"));

        var validator = new HighCardHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(5, validator.getCards().size(), "Expected five cards to be in hand");
    }
}
