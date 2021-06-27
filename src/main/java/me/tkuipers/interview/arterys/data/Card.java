package me.tkuipers.interview.arterys.data;

public class Card {
    private final Suit suit;
    private final int value;

    public Card(Suit suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public static Card fromString(String cardString) {
        return new Card(Suit.fromChar(cardString.charAt(1)), getValue(cardString.charAt(0)));
    }

    private static int getValue(Character val) {
        if(Character.isDigit(val)){
            return Integer.parseInt(val.toString()) - 2;
        }
        else{
            switch(val){
                case 'T':
                    return 8;
                case 'J':
                    return 9;
                case 'Q':
                    return 10;
                case 'K':
                    return 11;
                case 'A':
                    return 12;
            }
        }
        throw new IllegalArgumentException("Cannot get the value of " + val + " to create the card");

    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return getFaceFromValue(value);
    }

    public static String getFaceFromValue(int val) {
        switch(val) {
            case 0:
                return "Two";
            case 1:
                return "Three";
            case 2:
                return "Four";
            case 3:
                return "Five";
            case 4:
                return "Six";
            case 5:
                return "Seven";
            case 6:
                return "Eight";
            case 7:
                return "Nine";
            case 8:
                return "Ten";
            case 9:
                return "Jack";
            case 10:
                return "Queen";
            case 11:
                return "King";
            case 12:
                return "Ace";
        }
        return null;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (value != card.value) return false;
        return suit == card.suit;
    }
}
