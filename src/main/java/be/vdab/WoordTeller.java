package be.vdab;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WoordTeller {
    private final String zin;
    private String[] woorden;

    public WoordTeller(String zin) {
        this.zin = zin;
    }

    public long getAantalWoorden() {
        return Stream.of(zin)
                .map(woorden -> woorden.toLowerCase().split(" "))
                .flatMap(array -> Arrays.stream(array))
                .filter(woorden -> woorden.length() > 0)
                .distinct()
                .count();
    }
}
