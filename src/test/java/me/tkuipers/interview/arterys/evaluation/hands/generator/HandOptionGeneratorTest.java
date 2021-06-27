package me.tkuipers.interview.arterys.evaluation.hands.generator;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandOptionGeneratorTest {
    @Test
    public void sevenCards() {
        var h = Lists.newArrayList(
                Card.fromString("AD"), Card.fromString("2D"), Card.fromString("3D"), Card.fromString("4D"),
                Card.fromString("5D"), Card.fromString("6D"), Card.fromString("7D"));
        var gen = new HandOptionGenerator(h);
        var allHands = gen.combine();

        assertEquals(21, allHands.size(), "Expected a total of 21 hand options");
    }

    @Test
    public void sixCards() {
        var h = Lists.newArrayList(
                Card.fromString("AD"), Card.fromString("2D"), Card.fromString("3D"), Card.fromString("4D"),
                Card.fromString("5D"), Card.fromString("6D"));
        var gen = new HandOptionGenerator(h);
        var allHands = gen.combine();

        assertEquals(6, allHands.size(), "Expected a total of 6 hand options");
    }
}
