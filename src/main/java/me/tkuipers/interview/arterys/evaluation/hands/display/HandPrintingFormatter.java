package me.tkuipers.interview.arterys.evaluation.hands.display;

import com.google.common.collect.ImmutableList;
import me.tkuipers.interview.arterys.data.Card;
import me.tkuipers.interview.arterys.data.HandValidation;

public interface HandPrintingFormatter {
    String getDescription(HandValidation validation);
}
