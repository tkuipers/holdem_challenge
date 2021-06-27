package me.tkuipers.interview.arterys.data;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import me.tkuipers.interview.arterys.evaluation.hands.generator.HandOptionGenerator;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The player object, contains the player and all information
 * about them.
 */
public class Player {
    private final String name;
    private final ImmutableCollection<Card> cards;
    private final ImmutableCollection<Card> communityCards;
    private final HandOptionGenerator optionGen;
    private HandValidation bestHand;

    public static Player fromString(String player, Collection<Card> community) {
        var cardStrings = player.split("\\s+");
        return new Player(cardStrings[0], cardStrings[1], cardStrings[2], community);
    }

    private Player(String name, String firstCard, String secondCard, Collection<Card> community) {
        this.name = name;
        cards = ImmutableList.of(Card.fromString(firstCard), Card.fromString(secondCard));
        communityCards = ImmutableList.copyOf(community);
        this.optionGen = new HandOptionGenerator(Stream.concat(cards.stream(), communityCards.stream()).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }

    public String getOutputString(){
        return name + " " + bestHand.getHandDescription();
    }

    public HandValidation getBestHand() {
        return bestHand;
    }

    public void setBestHand(HandValidation bestHand) {
        this.bestHand = bestHand;
    }

    public String getName() {
        return name;
    }

    public ImmutableCollection<Card> getOwnCards() {
        return cards;
    }

    public Collection<List<Card>> getHands() {
        return optionGen.combine();
    }
}
