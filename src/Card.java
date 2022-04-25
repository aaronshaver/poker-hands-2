
public class Card {
    private final Suit suit;
    private final Rank rank;

    Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;

    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return getRank().toString() + getSuit().toString();
    }

}
