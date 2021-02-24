package be.vdab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class IsbnTest {
    @ParameterizedTest
    @ValueSource(longs = {9789027439642L, 9789227439640L})
    void correcteNummers(long nummer) {
        new Isbn(nummer);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -9789027439642L, 978902743964L, 97890274396425L, 9789027439643L})
    void verkeerdeNummers(long nummer) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(nummer));
    }

    @Test
    void toStringMoetHetNummerTeruggeven() {
        assertThat(new Isbn(9789227439640L)).hasToString("9789227439640");
    }
}