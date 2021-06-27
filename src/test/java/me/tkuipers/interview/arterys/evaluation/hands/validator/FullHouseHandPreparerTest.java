package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FullHouseHandPreparerTest {
    @Test
    public void validCase3AndAce() {
        var hand = Lists.newArrayList(Card.fromString("3H"), Card.fromString("3S"), Card.fromString("AC"),
                Card.fromString("AD"), Card.fromString("AH"));

        var validator = new FullHouseHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(HandType.FULL_HOUSE, validator.getType());
        assertEquals(5, validator.getCards().size(), "Expected all cards to be in hand");
    }

    @Test
    public void validCase2AndAce() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("2C"),
                Card.fromString("2D"), Card.fromString("AH"));

        var validator = new FullHouseHandPreparer().evaluateHand(hand);

        assertTrue(validator.isValid(), hand.toString());
        assertEquals(5, validator.getCards().size(), "Expected all cards to be in hand");
    }

    @Test
    public void failCase() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("2H"), Card.fromString("2C"),
                Card.fromString("4D"), Card.fromString("3H"));

        var validator = new FullHouseHandPreparer().evaluateHand(hand);

        assertFalse(validator.isValid(), "Expected hand not to be valid: " + hand);
    }
}
