package me.tkuipers.interview.arterys.evaluation;

import com.google.common.collect.Lists;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.Player;
import me.tkuipers.interview.arterys.input.InputReader;
import me.tkuipers.interview.arterys.log.Log;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class CardParser {
    private static final Logger LOG = Log.getLogger(CardParser.class.getSimpleName());
    private final List<Player> players;

    public CardParser(InputReader reader) {
        Collection<Card> community = Lists.newArrayList();
        players = Lists.newArrayList();
        LOG.info("Beginning to evaluate community hand");

        for(var cardString : reader.getCommunityString().split("\\s+")) {
            community.add(Card.fromString(cardString));
        }
        LOG.info("Evaludated community hand: " + community);

        LOG.info("Beginning to evaluate players");
        for(var playerString : reader.getPlayers()) {
            players.add(Player.fromString(playerString, community));
        }
        LOG.info("Evaluated Players: " + players);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
