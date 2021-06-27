package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FourOfAKindHandPreparerTest {
    @Test
    public void fourAces() {
        var hand = Lists.newArrayList(Card.fromString("3H"), Card.fromString("AS"), Card.fromString("AC"),
                Card.fromString("AD"), Card.fromString("AH"));

        var validator = new FourOfAKindHandPreparer().evaluateHand(hand);

        Assertions.assertTrue(validator.isValid(), "Expected hand to be a valid hand: " + hand);
        Assertions.assertEquals(HandType.FOUR_OF_A_KIND, validator.getType());
        Assertions.assertEquals(5, validator.getCards().size());
        Assertions.assertEquals(4, validator.getType().getHandSize());
    }

    @Test
    public void fourTwos() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("2C"),
                Card.fromString("2D"), Card.fromString("2H"));

        var validator = new FourOfAKindHandPreparer().evaluateHand(hand);

        Assertions.assertTrue(validator.isValid(), hand.toString());
        Assertions.assertEquals(5, validator.getCards().size());
        Assertions.assertEquals(4, validator.getType().getHandSize());
    }

    @Test
    public void fullHouse() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("2H"), Card.fromString("2C"),
                Card.fromString("3D"), Card.fromString("3H"));

        var validator = new FourOfAKindHandPreparer().evaluateHand(hand);

        Assertions.assertFalse(validator.isValid(), "Expected hand not to be valid: " + hand);
    }
}
