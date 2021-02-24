package be.vdab;

public class Isbn {
    private final long nummer;

    public Isbn(long nummer) {
        if (nummer < 9780000000000L || nummer > 9799999999999L) {
            throw new IllegalArgumentException("Verkeerd formaat");
        }
        var somEvenCijfers = nummer / 1000000000000L + nummer / 10000000000L % 10 + nummer / 100000000 % 10 + nummer / 1000000 % 10 + nummer / 10000 % 10 + nummer / 100 % 10;
        var driemaalSomOnEvenCijfers = (nummer / 100000000000L % 10 + nummer / 1000000000 % 10 + nummer / 10000000 % 10 + nummer / 100000 % 10 + nummer / 1000 % 10 + nummer / 10 % 10) * 3;
        var somTweeTussenresultaten = somEvenCijfers + driemaalSomOnEvenCijfers;
        var verschilVanSomEnNaastgelegenHogerTiental = (10 - somTweeTussenresultaten % 10) % 10;
        if (verschilVanSomEnNaastgelegenHogerTiental != nummer % 10) {
            throw new IllegalArgumentException("Verkeerd formaat");
        }
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return String.valueOf(nummer);
    }
}
