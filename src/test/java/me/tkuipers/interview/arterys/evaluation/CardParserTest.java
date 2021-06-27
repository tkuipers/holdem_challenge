package me.tkuipers.interview.arterys.evaluation;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.Player;
import me.tkuipers.interview.arterys.test.util.MockInputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
//Case where split by more than one space

public class CardParserTest {
    private MockInputReader reader;
    @BeforeEach
    public void setUp() {
        reader = new MockInputReader();
    }

    @Test
    public void workingCase(){
        reader.setPlayerString(
                Lists.newArrayList("Annie 4H 2D",
                        "John 3H 6C",
                        "Jackie 4D 6S"));
        reader.setCommunityString("AH 5S 2C KD 9S");

        var parser = new CardParser(reader);

        Assertions.assertEquals(3, parser.getPlayers().size());
        Assertions.assertEquals(
                Lists.newArrayList(Card.fromString("3H"), Card.fromString("6C")),
                getPlayer("John", parser.getPlayers()).getOwnCards());
        Assertions.assertEquals(
                Lists.newArrayList(Card.fromString("4H"), Card.fromString("2D")),
                getPlayer("Annie", parser.getPlayers()).getOwnCards());
        Assertions.assertEquals(
                Lists.newArrayList(Card.fromString("4D"), Card.fromString("6S")),
                getPlayer("Jackie", parser.getPlayers()).getOwnCards());
    }

    @Test
    public void workingCaseWithExtraSpaces(){
        reader.setPlayerString(
                Lists.newArrayList("Annie 4H                       2D",
                        "John 3H          6C",
                        "Jackie     4D 6S"));
        reader.setCommunityString("AH 5S    2C KD 9S");

        var parser = new CardParser(reader);

        Assertions.assertEquals(3, parser.getPlayers().size());
        Assertions.assertEquals(
                Lists.newArrayList(Card.fromString("3H"), Card.fromString("6C")),
                getPlayer("John", parser.getPlayers()).getOwnCards());
        Assertions.assertEquals(
                Lists.newArrayList(Card.fromString("4H"), Card.fromString("2D")),
                getPlayer("Annie", parser.getPlayers()).getOwnCards());
        Assertions.assertEquals(
                Lists.newArrayList(Card.fromString("4D"), Card.fromString("6S")),
                getPlayer("Jackie", parser.getPlayers()).getOwnCards());
    }

    private Player getPlayer(String name, Collection<Player> players) {
        for(var player : players) {
            if(player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }
}
