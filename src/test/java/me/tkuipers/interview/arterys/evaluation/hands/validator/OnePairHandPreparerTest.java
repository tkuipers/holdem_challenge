package me.tkuipers.interview.arterys.evaluation.hands.validator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnePairHandPreparerTest {
    @Test
    public void passCase() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("7C"),
                Card.fromString("6D"), Card.fromString("2H"));

        var validator = new OnePairHandPreparer().evaluateHand(hand);

        Assertions.assertTrue(validator.isValid(), hand.toString());
        Assertions.assertEquals(HandType.ONE_PAIR, validator.getType());
        Assertions.assertEquals(5, validator.getCards().size(), "Expected two cards to be in hand");
        Assertions.assertEquals(2, validator.getType().getHandSize());
    }

    @Test
    public void threeOfAKind() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("7C"),
                Card.fromString("2D"), Card.fromString("2H"));

        var validator = new OnePairHandPreparer().evaluateHand(hand);

        Assertions.assertFalse(validator.isValid(), hand.toString());
    }

    @Test
    public void noPair() {
        var hand = Lists.newArrayList(Card.fromString("2S"), Card.fromString("AS"), Card.fromString("7C"),
                Card.fromString("9D"), Card.fromString("TH"));

        var validator = new OnePairHandPreparer().evaluateHand(hand);

        Assertions.assertFalse(validator.isValid(), hand.toString());
    }
}
