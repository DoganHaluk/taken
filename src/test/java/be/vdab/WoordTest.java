package be.vdab;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WoordTest {
    @Test
    void deWoordLepelIsEenPalindroom() {
        assertThat(new Woord("lepel").isPalindroom()).isTrue();
    }

    @Test
    void deWoordVorkIsGeenPalindroom() {
        assertThat(new Woord("vork").isPalindroom()).isFalse();
    }
}