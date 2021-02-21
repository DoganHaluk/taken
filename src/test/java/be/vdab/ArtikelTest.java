package be.vdab;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ArtikelTest {

    @Test
    void prijsExclusief30enBtwPercentage6Moet31komma8PrijsInclusiefZijn() {
        assertThat(new Artikel(BigDecimal.valueOf(30), BigDecimal.valueOf(6)).getPrijsInclusiefBtw()).isEqualByComparingTo("31.8");
    }
}