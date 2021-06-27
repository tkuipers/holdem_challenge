package me.tkuipers.interview.arterys.data;

import me.tkuipers.interview.arterys.evaluation.hands.display.HandPrintingFormatter;
import me.tkuipers.interview.arterys.evaluation.hands.display.HandPrintingFormatters;

public enum HandType {
    ROYAL_FLUSH(1100, "Royal Flush", HandPrintingFormatters.PRINT_NOTHING),
    STRAIGHT_FLUSH(1000, "Straight Flush", HandPrintingFormatters.HIGH_CARD),
    FOUR_OF_A_KIND(900, "Four of a Kind", HandPrintingFormatters.UNIQUE_VALUES),
    FULL_HOUSE(800, "Full House", HandPrintingFormatters.UNIQUE_VALUES),
    FLUSH(700, "Flush", HandPrintingFormatters.HIGH_CARD),
    STRAIGHT(600, "Straight", HandPrintingFormatters.HIGH_CARD),
    THREE_OF_A_KIND(500, "Three of a kind", HandPrintingFormatters.UNIQUE_VALUES),
    TWO_PAIR(400, "Two Pair", HandPrintingFormatters.UNIQUE_VALUES),
    ONE_PAIR(300, "Pair", HandPrintingFormatters.UNIQUE_VALUES),
    HIGH_CARD(200, "High", HandPrintingFormatters.HIGH_CARD);

    private final int value;
    private final String description;
    private final HandPrintingFormatter printer;

    HandType(int value, String description, HandPrintingFormatter printFormatter) {
        this.value = value;
        this.description = description;
        this.printer = printFormatter;
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
}
