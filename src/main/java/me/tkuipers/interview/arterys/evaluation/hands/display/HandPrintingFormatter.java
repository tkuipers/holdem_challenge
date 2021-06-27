package me.tkuipers.interview.arterys.evaluation.hands.display;

import me.tkuipers.interview.arterys.data.HandValidation;

/**
 * Interface for determining the way to print a hand.
 */
public interface HandPrintingFormatter {
    String getDescription(HandValidation validation);
}
