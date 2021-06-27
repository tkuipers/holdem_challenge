package me.tkuipers.interview.arterys.evaluation.hands;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandType;
import me.tkuipers.interview.arterys.data.HandValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HandValidationComparerTest {
    @Test
    public void differentHandType(){
        var handOne = new HandValidation(true,
                Lists.newArrayList(Card.fromString("TH"), Card.fromString("JH"), Card.fromString("QH"),
                        Card.fromString("KH"), Card.fromString("AH")), HandType.ROYAL_FLUSH);
        var handTwo = new HandValidation(true,
                Lists.newArrayList(Card.fromString("9H"), Card.fromString("TH"), Card.fromString("JH"),
                        Card.fromString("QH"), Card.fromString("KH")), HandType.STRAIGHT_FLUSH);

        Assertions.assertEquals(1, new HandValidationComparer(false).compareAscending(handOne, handTwo));
    }

    @Test
    public void sameHandHigherVal(){
        var handOne = new HandValidation(true,
                Lists.newArrayList(Card.fromString("QH"), Card.fromString("JH"), Card.fromString("AH"), Card.fromString("TH"), Card.fromString("TD")),
                HandType.ONE_PAIR);
        var handTwo = new HandValidation(true,
                Lists.newArrayList(Card.fromString("9H"), Card.fromString("TH"), Card.fromString("JH"), Card.fromString("QH"), Card.fromString("QD")),
                HandType.ONE_PAIR);

        Assertions.assertEquals(-1, new HandValidationComparer(false).compareAscending(handOne, handTwo));
    }

    @Test
    public void equalHandHigherKicker(){
        var handOne = new HandValidation(true,
                Lists.newArrayList(Card.fromString("QH"), Card.fromString("JH"), Card.fromString("AH"), Card.fromString("QH"), Card.fromString("QD")),
                HandType.ONE_PAIR);
        var handTwo = new HandValidation(true,
                Lists.newArrayList(Card.fromString("9H"), Card.fromString("TH"), Card.fromString("JH"), Card.fromString("QH"), Card.fromString("QD")),
                HandType.ONE_PAIR);

        var equalVal = new HandValidationComparer(true).compareAscending(handOne, handTwo);

        Assertions.assertEquals(1, equalVal);
        Assertions.assertTrue(handOne.isKickerMatters());
    }

    @Test
    public void equalHand(){
        var handOne = new HandValidation(true,
                Lists.newArrayList(Card.fromString("QH"), Card.fromString("JH"), Card.fromString("AH"), Card.fromString("TH"), Card.fromString("TD")),
                HandType.ONE_PAIR);
        var handTwo = new HandValidation(true,
                Lists.newArrayList(Card.fromString("QH"), Card.fromString("JH"), Card.fromString("AH"), Card.fromString("TH"), Card.fromString("TD")),
                HandType.ONE_PAIR);

        Assertions.assertEquals(0, new HandValidationComparer(false).compareAscending(handOne, handTwo));
    }

    @Test
    public void testStraightWheelComparison(){
        var handOne = new HandValidation(true,
                Lists.newArrayList(Card.fromString("AH"), Card.fromString("2H"), Card.fromString("3D"),
                        Card.fromString("4H"), Card.fromString("5H")),
                HandType.STRAIGHT);
        var handTwo = new HandValidation(true,
                Lists.newArrayList(Card.fromString("2H"), Card.fromString("3D"),
                        Card.fromString("4H"), Card.fromString("5H"), Card.fromString("6H")),
                HandType.STRAIGHT);

        Assertions.assertEquals(-1, new HandValidationComparer(false).compareAscending(handOne, handTwo));
    }

    @Test
    public void testEqualStraightWheelComparison(){
        var handOne = new HandValidation(true,
                Lists.newArrayList(Card.fromString("AH"), Card.fromString("2H"), Card.fromString("3D"),
                        Card.fromString("4H"), Card.fromString("5H")),
                HandType.STRAIGHT);
        var handTwo = new HandValidation(true,
                Lists.newArrayList(Card.fromString("AH"), Card.fromString("2H"), Card.fromString("3D"),
                        Card.fromString("4H"), Card.fromString("5H")),
                HandType.STRAIGHT);

        Assertions.assertEquals(0, new HandValidationComparer(false).compareAscending(handOne, handTwo));
    }

    @Test
    public void twoPairEqualHighPair(){
        var handOne = new HandValidation(true,
                Lists.newArrayList(Card.fromString("AH"), Card.fromString("TH"), Card.fromString("TD"),
                        Card.fromString("QH"), Card.fromString("QH")),
                HandType.TWO_PAIR);
        var handTwo = new HandValidation(true,
                Lists.newArrayList(Card.fromString("AH"), Card.fromString("2H"), Card.fromString("2D"),
                        Card.fromString("QH"), Card.fromString("QH")),
                HandType.TWO_PAIR);

        Assertions.assertEquals(1, new HandValidationComparer(false).compareAscending(handOne, handTwo));
    }
}
