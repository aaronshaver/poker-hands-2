import java.util.*;

public class HandRankEngine {

    public static String getHandRank(ArrayList<Card> hand) {

        boolean isFlush = getIsFlush(hand);
        if (isFlush) return "Flush";

        final List<CardRank> handRanks = hand.stream()
                .map(Card::getRank)
                .toList();

        final HashMap<CardRank, Integer> rankCounts = getRankCounts(handRanks);

        List<Integer> rankCountsSorted = rankCounts.values().stream().sorted().toList();

        if (rankCountsSorted.equals(List.of(1, 4))) {
            return "Four of a kind";
        } else if (rankCountsSorted.equals(List.of(1, 1, 3))) {
            return "Three of a kind";
        } else if (rankCountsSorted.equals(List.of(2, 3))) {
            return "Full house";
        } else if (rankCountsSorted.equals(List.of(1, 2, 2))) {
            return "Two pair";
        } else if (rankCountsSorted.equals(List.of(1, 1, 1, 2))) {
            return "One pair";
        }
        
        return "High card";
    }

    private static boolean getIsFlush(ArrayList<Card> hand) {
        final Suit suitFirstCard = hand.get(0).getSuit();
        final boolean isFlush = hand.stream()
                .allMatch(card -> card.getSuit() == suitFirstCard);
        return isFlush;
    }

    private static HashMap<CardRank, Integer> getRankCounts(List<CardRank> handRanks) {
        final HashMap<CardRank, Integer> rankCounts = new HashMap<>();
        for (CardRank cardRank : handRanks) {
            if (!rankCounts.containsKey(cardRank)) {
                rankCounts.put(cardRank, 1);
            } else {
                rankCounts.put(cardRank, rankCounts.get(cardRank) + 1);
            }
        }
        return rankCounts;
    }

    public static int getNumericRank(CardRank cardRank, boolean hasFive) {
        if (cardRank.equals(CardRank.ACE)) {
            if (hasFive) return 1;
            else return 13;
        }
        return switch (cardRank) {
            case TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN -> Integer.parseInt(cardRank.toString());
            case JACK -> 11;
            case QUEEN -> 12;
            case KING -> 13;
            default -> throw new IllegalStateException("Unexpected value: " + cardRank);
        };
    }
}