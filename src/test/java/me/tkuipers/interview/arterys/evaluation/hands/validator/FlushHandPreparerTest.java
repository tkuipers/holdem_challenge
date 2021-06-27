package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlushHandPreparerTest {
    @Test
    public void allHearts() {
        var hand = Lists.newArrayList(Card.fromString("4H"), Card.fromString("5H"), Card.fromString("6H"),
                Card.fromString("8H"), Card.fromString("AH"));

        var validator = new FlushHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.FLUSH, validator.getType());
        assertEquals(5, validator.getCards().size(), "Expected all cards to be in hand");
    }

    @Test
    public void allDiamonds() {
        var hand = Lists.newArrayList(Card.fromString("4D"), Card.fromString("5D"), Card.fromString("6D"),
                Card.fromString("8D"), Card.fromString("AD"));

        var validator = new FlushHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(5, validator.getCards().size(), "Expected all cards to be in hand");
    }

    @Test
    public void oneDiamond() {
        var hand = Lists.newArrayList(Card.fromString("4D"), Card.fromString("5H"), Card.fromString("6H"),
                Card.fromString("8H"), Card.fromString("AH"));

        var validator = new FlushHandPreparer().evaluateHand(hand);

        assertFalse(validator.isValid(), hand.toString());
    }
}
