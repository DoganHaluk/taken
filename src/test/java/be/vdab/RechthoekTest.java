package be.vdab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RechthoekTest {
    private Rechthoek rechthoek;

    @BeforeEach
    void beforeEach() {
        rechthoek = new Rechthoek(4, 3);
    }

    @Test
    void deOppervlakteVanEenRechthoekLengte4Breedte3Is12() {
        assertThat(rechthoek.getOppervlakte()).isEqualTo(12);
    }

    @Test
    void deOmtrekVanEenRechthoekLengte4Breedte3Is14() {
        assertThat(rechthoek.getOmtrek()).isEqualTo(14);
    }

    @Test
    void recthoekenMetHetzelfdeLengteEnBreedteZijnGelijk() {
        assertThat(new Rechthoek(5, 3)).isEqualTo(new Rechthoek(5, 3));
    }

    @Test
    void recthoekenMetVerschillendLengteOfBreedteZijnVerschillend() {
        assertThat(new Rechthoek(5, 3)).isNotEqualTo(new Rechthoek(5, 2));
    }

    @Test
    void deLengteMagNietNegatiefZijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(-2, 5));
    }

    @Test
    void deBreedteMagNietNegatiefZijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(5, -2));
    }

    @Test
    void deBreedteMagNietGroterDanLengte() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(4, 5));
    }
}