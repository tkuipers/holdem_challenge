package me.tkuipers.interview.arterys.data;

public enum Suit {
    //TODO: Remove this idea of values, we won't be hashing.
    HEARTS(0),
    DIAMONDS(13),
    CLUBS(26),
    SPADES(39);

    private final int value;

    Suit(int startingVal) {
        value = startingVal;
    }

    public static Suit fromChar(Character val) {
        switch(val){
            case 'H':
                return HEARTS;
            case 'S':
                return SPADES;
            case 'D':
                return DIAMONDS;
            case 'C':
                return CLUBS;
        }
        throw new IllegalArgumentException("Cannot create class from: " + val);
    }

    public int getValue() {
        return value;
    }
}
