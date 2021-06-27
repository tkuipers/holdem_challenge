package me.tkuipers.interview.arterys.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardDisplayTest {
    @Test
    public void testFace() {
        Assertions.assertEquals("King", Card.getFaceFromValue(11));
    }

    @Test
    public void testNum() {
        Assertions.assertEquals("Two", Card.getFaceFromValue(0));
    }
}
