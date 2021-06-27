package me.tkuipers.interview.arterys.evaluation.engine;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluationEngineTest {
    @Test
    public void playerWithRF() {
        var p = Player.fromString("Testy AH TH",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("2C"),
                        Card.fromString("JH"),
                        Card.fromString("4D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.ROYAL_FLUSH, validation.getType());
    }

    @Test
    public void playerWithStraightFlush() {
        var p = Player.fromString("Testy 9H TH",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("2C"),
                        Card.fromString("JH"),
                        Card.fromString("4D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.STRAIGHT_FLUSH, validation.getType());
    }

    @Test
    public void playerWithFourOfKind() {
        var p = Player.fromString("Testy 9H 9S",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("9C"),
                        Card.fromString("JH"),
                        Card.fromString("9D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.FOUR_OF_A_KIND, validation.getType());
    }

    @Test
    public void playerWithFullHouse() {
        var p = Player.fromString("Testy 9H 9S",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("2C"),
                        Card.fromString("2H"),
                        Card.fromString("2D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.FULL_HOUSE, validation.getType());
    }

    @Test
    public void playerWithFlush() {
        var p = Player.fromString("Testy 9H 2H",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("6H"),
                        Card.fromString("2S"),
                        Card.fromString("2D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.FLUSH, validation.getType());
    }

    @Test
    public void playerWithStraight() {
        var p = Player.fromString("Testy 9H 2D",
                Lists.newArrayList(Card.fromString("3H"),
                        Card.fromString("4H"),
                        Card.fromString("5S"),
                        Card.fromString("6D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.STRAIGHT, validation.getType());
    }

    @Test
    public void playerWithThreeOfKind() {
        var p = Player.fromString("Testy 9H 2H",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("6D"),
                        Card.fromString("2S"),
                        Card.fromString("2D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.THREE_OF_A_KIND, validation.getType());
    }

    @Test
    public void playerWithTwoPair() {
        var p = Player.fromString("Testy 9H 2H",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("6D"),
                        Card.fromString("2S"),
                        Card.fromString("9D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.TWO_PAIR, validation.getType());
    }

    @Test
    public void playerWithOnePair() {
        var p = Player.fromString("Testy 9H 2H",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("6D"),
                        Card.fromString("TS"),
                        Card.fromString("9D"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.ONE_PAIR, validation.getType());
    }

    @Test
    public void playerWithHighCard() {
        var p = Player.fromString("Testy 9H 2H",
                Lists.newArrayList(Card.fromString("QH"),
                        Card.fromString("6D"),
                        Card.fromString("TS"),
                        Card.fromString("AD"),
                        Card.fromString("KH")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.HIGH_CARD, validation.getType());
    }

    @Test
    public void playerWithWheel() {
        var p = Player.fromString("Testy AH 4H",
                Lists.newArrayList(Card.fromString("3H"),
                        Card.fromString("5H"),
                        Card.fromString("TS"),
                        Card.fromString("AD"),
                        Card.fromString("2H")));
        var engine = new EvaluationEngine();

        var validation = engine.evaluate(p);

        Assertions.assertEquals(HandType.STRAIGHT_FLUSH, validation.getType());
    }
}
