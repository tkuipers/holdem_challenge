package me.tkuipers.interview.arterys.evaluation.hands.display;

import com.google.common.collect.ImmutableList;
import me.tkuipers.interview.arterys.data.Card;

public interface HandPrintingFormatter {
    String getDescription(ImmutableList<Card> hand);
}
