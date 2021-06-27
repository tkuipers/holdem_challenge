package me.tkuipers.interview.arterys.data;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerOutputTest {

    @Test
    public void playerPrintsNoKicker(){
        var hand = ImmutableList.of(
                Card.fromString("2S"),
                Card.fromString("4H"),
                Card.fromString("KS"),
                Card.fromString("AH"),
                Card.fromString("AD"));
        var validation = new HandValidation(true, hand, HandType.ROYAL_FLUSH);
        var player = Player.fromString("Sally 7S 7H", hand);

        player.setBestHand(validation);

        Assertions.assertEquals("Sally Royal Flush", player.getOutputString().trim());
    }

    @Test
    public void playerPrintsKicker(){
        var hand = ImmutableList.of(
                Card.fromString("2S"),
                Card.fromString("4H"),
                Card.fromString("KS"),
                Card.fromString("AH"),
                Card.fromString("AD"));
        var validation = new HandValidation(true, hand, HandType.ONE_PAIR);
        validation.addKicker(Card.fromString("KS"));
        var player = Player.fromString("Sally 7S 7H", hand);

        player.setBestHand(validation);

        Assertions.assertEquals("Sally Pair Ace, Kicker(s): King", player.getOutputString().trim());
    }
}
