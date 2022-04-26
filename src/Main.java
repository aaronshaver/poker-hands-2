import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // TODO: Accept cmd line arg: "generating X hands..." then show stats of each type and keys are ordered map?
        final Optional<String> numHandsRaw = Arrays.stream(args).findFirst();
        int numHands;
        if(numHandsRaw.isPresent()) {
            numHands = Integer.parseInt(numHandsRaw.get());
        } else {
            throw new IllegalArgumentException("Must specify number of poker hands to generate as first argument");

        }
        System.out.printf("Generating %d poker hand(s)...%n", numHands);
    }

}