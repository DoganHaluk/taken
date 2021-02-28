package be.vdab;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WoordTellerTest {

    @Test
    void aantalWoordenVanDeZinIs5() {
        assertThat(new WoordTeller("Zoek  het aantal   woorden in een zin, een par een").getAantalWoorden()).isEqualByComparingTo(Long.valueOf("8"));
    }
}