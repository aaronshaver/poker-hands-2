import java.util.*;

public class HandRankEngine {

    public static String getHandRank(Hand hand) {
        if (hand.size() != 5) {
            throw new IllegalArgumentException(String.format("Can only evaluate hands with exactly 5 cards; %d cards were supplied", hand.size()));
        }

        boolean isFlush = getIsFlush(hand);

        final List<CardRank> handRanks = hand.getCards().stream()
                .map(Card::getRank)
                .sorted()
                .toList();

        final HashMap<CardRank, Integer> rankCounts = getRankCounts(handRanks);

        List<Integer> rankCountsSorted = rankCounts.values().stream().sorted().toList();

        final boolean hasFive = rankCounts.containsKey(CardRank.FIVE);

        List<Integer> handRanksNumeric = handRanks.stream()
                .map(cardRank -> getNumericRank(cardRank, hasFive))
                .sorted()
                .toList();
        boolean isStraight = true;
        for (int i = 1; i < handRanksNumeric.size(); i++) {
            if (Math.abs(handRanksNumeric.get(i) - handRanksNumeric.get(i - 1)) > 1) {
                isStraight = false;
                break;
            }
        }

        if (isFlush && isStraight) {
            if (handRanksNumeric.contains(10) && handRanksNumeric.contains(14)) {
                return "Royal flush";
            }
        }

        if (isFlush && isStraight) return "Straight flush";
        if (isStraight) return "Straight";
        if (isFlush) return "Flush";

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

    private static boolean getIsFlush(Hand hand) {
        final Suit suitFirstCard = hand.getCards().get(0).getSuit();
        final boolean isFlush = hand.getCards().stream()
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

    /**
     *
     * @param cardRank  Where "rank" means 2 for Two, 11 for Jack, etc.
     * @param hasFive   A straight which includes 5 is the only case of an Ace being low;
     *                  Note we're making the simplifying assumption of not ranking four of kinds, full houses, etc.
     *                  against each other, where an Ace's numeric equivalent would matter
     * @return
     */
    public static int getNumericRank(CardRank cardRank, boolean hasFive) {
        if (cardRank.equals(CardRank.ACE)) {
            if (hasFive) return 1;
            else return 14;
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