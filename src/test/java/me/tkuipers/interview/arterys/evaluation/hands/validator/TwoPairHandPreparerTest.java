package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoPairHandPreparerTest {
    @Test
    public void passCase() {
        var hand = Lists.newArrayList(Card.fromString("5H"), Card.fromString("5D"), Card.fromString("6C"),
                Card.fromString("4S"), Card.fromString("4D"));

        var validator = new TwoPairHandPreparer().evaluateHand(hand);

        Assertions.assertTrue(validator.isValid(), hand.toString());
        Assertions.assertEquals(HandType.TWO_PAIR, validator.getType());
        Assertions.assertEquals(5, validator.getCards().size(), "Expected 3 cards to be in hand");
        Assertions.assertEquals(4, validator.getType().getHandSize());
    }

    @Test
    public void fullHouse() {
        var hand = Lists.newArrayList(Card.fromString("5H"), Card.fromString("5D"), Card.fromString("4C"),
                Card.fromString("4S"), Card.fromString("5D"));

        var validator = new TwoPairHandPreparer().evaluateHand(hand);

        Assertions.assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void threeOfAKind() {
        var hand = Lists.newArrayList(Card.fromString("5H"), Card.fromString("5D"), Card.fromString("6C"),
                Card.fromString("4S"), Card.fromString("5D"));

        var validator = new TwoPairHandPreparer().evaluateHand(hand);

        Assertions.assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void onePair() {
        var hand = Lists.newArrayList(Card.fromString("5H"), Card.fromString("6D"), Card.fromString("7C"),
                Card.fromString("8S"), Card.fromString("5D"));

        var validator = new TwoPairHandPreparer().evaluateHand(hand);

        Assertions.assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void noPair() {
        var hand = Lists.newArrayList(Card.fromString("5H"), Card.fromString("6D"), Card.fromString("7C"),
                Card.fromString("8S"), Card.fromString("9D"));

        var validator = new TwoPairHandPreparer().evaluateHand(hand);

        Assertions.assertFalse(validator.isValid(), hand.toString());
    }
}
