package me.tkuipers.interview.arterys.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandValidation {
    private static final String KICKER_PROP = "kicker";
    private static final String LOW_WHEEL_PROP = "low_wheel";

    private final boolean isValid;
    private final ImmutableList<Card> inHandCards;
    private final ImmutableList<Card> outOfHand;
    private HandType type;
    private Set<String> properties;

    public HandValidation(boolean isValid, List<Card> inHandCards, List<Card> outOfHandCards, HandType handType) {
        this.isValid = isValid;
        this.inHandCards = ImmutableList.copyOf(inHandCards);
        this.outOfHand = ImmutableList.copyOf(outOfHandCards);
        this.type = handType;
        this.properties = Sets.newHashSet();
    }

    public HandValidation(boolean isValid) {
        if(isValid) {
            throw new IllegalArgumentException("Cannot create an empty valid hand");
        }
        this.isValid = false;
        inHandCards = null;
        outOfHand = null;
        type = null;
        this.properties = null;
    }

    public boolean isValid() {
        return isValid;
    }

    public ImmutableList<Card> getInHandCards() {
        return inHandCards;
    }

    public ImmutableList<Card> getOutOfHandCards() {
        return outOfHand;
    }

    public HandType getType() {
        return type;
    }

    public String getHandDescription() {
        var base = this.type.getDescription() + " " + this.type.getPrinter().getDescription(inHandCards);
        if(isKickerMatters()) {
            base += ", Kicker(s): " + this.outOfHand.stream().map(c -> Card.getFaceFromValue(c.getValue())).collect(Collectors.joining(" "));
        }
        return base;
    }

    public void setKickerMatters(boolean matters) {
        if(!matters){
            properties.remove(KICKER_PROP);
        }
        else{
            properties.add(KICKER_PROP);
        }
    }

    public boolean isKickerMatters() {
        return properties.contains(KICKER_PROP);
    }

    public void setLowWheel(boolean lowWheel){
        if(!lowWheel){
            properties.remove(LOW_WHEEL_PROP);
        }
        else{
            properties.add(LOW_WHEEL_PROP);
        }
    }

    public boolean isLowWheel() {
        return properties.contains(LOW_WHEEL_PROP);
    }

    public void setType(HandType type) {
        this.type = type;
    }
}
