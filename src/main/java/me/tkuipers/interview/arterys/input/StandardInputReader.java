package me.tkuipers.interview.arterys.input;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.logging.Logger;

import java.util.List;
import java.util.Scanner;

public class StandardInputReader implements InputReader {
    private static final Logger LOG = Logger.getLogger(StandardInputReader.class.getSimpleName());
    private final List<String> playerStrings;
    private final String communityString;

    public StandardInputReader() {
        LOG.info("Initializing StandardInputReader");
        Scanner scanner = new Scanner(System.in);
        playerStrings = Lists.newArrayList();
        communityString = scanner.nextLine();
        LOG.info("Read Community Hand.  Cards are: " + communityString);
        while(scanner.hasNextLine()){
            playerStrings.add(scanner.nextLine());
        }
        LOG.info("Read all player hands.  They are: " + playerStrings);

    }

    @Override
    public String getCommunityString() {
        return communityString;
    }

    @Override
    public Collection<String> getPlayers() {
        return playerStrings;
    }
}
