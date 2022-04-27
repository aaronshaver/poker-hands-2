import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandRankEngine {

    public static String getRank(ArrayList<Card> hand) {

        final Suit suitFirstCard = hand.get(0).getSuit();
        final boolean isFlush = hand.stream()
                .allMatch(card -> card.getSuit() == suitFirstCard);
        if (isFlush) return "Flush";

        final List<CardRank> ranks = hand.stream()
                .map(Card::getRank)
                .toList();

        Set<CardRank> seenRanks = new HashSet<>(ranks);
        if (seenRanks.size() < 5) {
            return "One pair";
        }

        return "High card";
    }
}
