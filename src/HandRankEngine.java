import java.util.*;

public class HandRankEngine {

    public static String getHandRank(Hand hand) {
        if (hand.size() != 5) {
            throw new IllegalArgumentException(String.format(
                    "Can only evaluate hands with exactly 5 cards; %d cards were supplied",
                    hand.size())
            );
        }

        final List<CardRank> cardRanks = getCardRanks(hand);

        final HashMap<CardRank, Integer> rankCounts = getRankCounts(cardRanks);
        List<Integer> rankCountsSorted = rankCounts.values().stream().sorted().toList();
        if (rankCountsSorted.equals(List.of(1, 4))) return "Four of a kind";
        if (rankCountsSorted.equals(List.of(1, 1, 3))) return "Three of a kind";
        if (rankCountsSorted.equals(List.of(2, 3))) return "Full house";
        if (rankCountsSorted.equals(List.of(1, 2, 2))) return "Two pair";
        if (rankCountsSorted.equals(List.of(1, 1, 1, 2))) return "One pair";

        final boolean hasFive = rankCounts.containsKey(CardRank.FIVE);
        List<Integer> handRanksNumeric = cardRanks.stream()
                .map(cardRank -> getNumericRank(cardRank, hasFive))
                .sorted()
                .toList();

        boolean isStraight = true;
        for (int i = 1; i < handRanksNumeric.size(); i++) {
            // if distance between sorted cards is more than 1, can't be a straight
            if (Math.abs(handRanksNumeric.get(i) - handRanksNumeric.get(i - 1)) > 1) {
                isStraight = false;
                break;
            }
        }

        boolean isFlush = getIsFlush(hand);
        if (isFlush && isStraight) {
            if (handRanksNumeric.contains(10) && handRanksNumeric.contains(14)) {
                return "Royal flush";
            } else {
                return "Straight flush";
            }
        }
        if (isStraight) return "Straight";
        if (isFlush) return "Flush";
        return "High card";
    }

    private static List<CardRank> getCardRanks(Hand hand) {
        final List<CardRank> handRanks = hand.getCards().stream()
                .map(Card::getRank)
                .sorted()
                .toList();
        return handRanks;
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
     * @param cardRank  raw enum of the rank
     * @param hasFive   A straight which includes 5 is the only case of an Ace being low;
     *                  Note we're making the simplifying assumption of not ranking four of kinds, full houses, etc.
     *                  against each other, where an Ace's numeric equivalent would matter
     * @return  integer representing numeric value of the card's rank
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