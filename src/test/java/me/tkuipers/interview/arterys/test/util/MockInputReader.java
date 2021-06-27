package me.tkuipers.interview.arterys.test.util;

import me.tkuipers.interview.arterys.input.InputReader;

import java.util.Collection;

public class MockInputReader implements InputReader {
    private String communityString;
    private Collection<String> playerString;

    @Override
    public String getCommunityString() {
        return communityString;
    }

    @Override
    public Collection<String> getPlayers() {
        return playerString;
    }

    public void setCommunityString(String communityString) {
        this.communityString = communityString;
    }

    public Collection<String> getPlayerString() {
        return playerString;
    }

    public void setPlayerString(Collection<String> playerString) {
        this.playerString = playerString;
    }
}
