package me.tkuipers.interview.arterys.data;

/**
 * The types of Suits available for a card.
 */
public enum Suit {
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES;

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
}
