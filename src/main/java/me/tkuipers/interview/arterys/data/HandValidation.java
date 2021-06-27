package me.tkuipers.interview.arterys.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class holds the prepared hands, and important metadata.  It is the primary object for performing
 * hand comparisons with.
 */
public class HandValidation {
    private final boolean isValid;
    private final ImmutableList<Card> cards;
    private HandType type;
    private Set<Card> kickers;

    public HandValidation(boolean isValid, List<Card> cards, HandType handType) {
        this.isValid = isValid;
        this.cards = ImmutableList.copyOf(cards);
        this.type = handType;
        this.kickers = Sets.newHashSet();
    }

    public HandValidation(boolean isValid) {
        if(isValid) {
            throw new IllegalArgumentException("Cannot create an empty valid hand");
        }
        this.isValid = false;
        cards = null;
        type = null;
    }

    public boolean isValid() {
        return isValid;
    }

    public ImmutableList<Card> getCards() {
        return cards;
    }

    public HandType getType() {
        return type;
    }

    public String getHandDescription() {
        var base = this.type.getDescription() + " " + this.type.getPrinter().getDescription(this);
        if(isKickerMatters()) {
            base += ", Kicker(s): " + this.kickers.stream().map(c -> Card.getFaceFromValue(c.getValue())).collect(Collectors.joining(" "));
        }
        return base;
    }

    public void addKicker(Card kicker) {
        this.kickers.add(kicker);
    }

    public boolean isKickerMatters() {
        return this.kickers.size() != 0;
    }

    public void setType(HandType type) {
        this.type = type;
    }
}
