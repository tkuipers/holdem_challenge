package me.tkuipers.interview.arterys.input;

import java.util.Collection;

/**
 * Interface for reading game input
 */
public interface InputReader {
    String getCommunityString();
    Collection<String> getPlayers();
}
