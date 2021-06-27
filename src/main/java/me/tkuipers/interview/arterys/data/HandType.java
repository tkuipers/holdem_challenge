package me.tkuipers.interview.arterys.data;

import me.tkuipers.interview.arterys.evaluation.hands.display.HandPrintingFormatter;
import me.tkuipers.interview.arterys.evaluation.hands.display.HandPrintingFormatters;

public enum HandType {
    ROYAL_FLUSH(1100, "Royal Flush", HandPrintingFormatters.PRINT_NOTHING, 5),
    STRAIGHT_FLUSH(1000, "Straight Flush", HandPrintingFormatters.HIGH_CARD, 5),
    FOUR_OF_A_KIND(900, "Four of a Kind", HandPrintingFormatters.UNIQUE_VALUES, 4),
    FULL_HOUSE(800, "Full House", HandPrintingFormatters.UNIQUE_VALUES, 5),
    FLUSH(700, "Flush", HandPrintingFormatters.HIGH_CARD, 5),
    STRAIGHT(600, "Straight", HandPrintingFormatters.HIGH_CARD, 5),
    THREE_OF_A_KIND(500, "Three of a kind", HandPrintingFormatters.UNIQUE_VALUES, 3),
    TWO_PAIR(400, "Two Pair", HandPrintingFormatters.UNIQUE_VALUES, 4),
    ONE_PAIR(300, "Pair", HandPrintingFormatters.UNIQUE_VALUES, 2),
    HIGH_CARD(200, "High", HandPrintingFormatters.HIGH_CARD, 1);

    private final int value;
    private final String description;
    private final HandPrintingFormatter printer;
    private final int handSize;


    HandType(int value, String description, HandPrintingFormatter printFormatter, int handSize) {
        this.value = value;
        this.description = description;
        this.printer = printFormatter;
        this.handSize = handSize;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public HandPrintingFormatter getPrinter() {
        return printer;
    }

    public int getHandSize() {
        return handSize;
    }
}
