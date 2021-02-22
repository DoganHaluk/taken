package be.vdab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RechthoekTest {
    private Rechthoek rechthoek;

    @BeforeEach
    void beforeEach() {
        rechthoek = new Rechthoek(3, 4);
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
        assertThat(new Rechthoek(3,5)).isEqualTo(new Rechthoek(3,5));
    }
    @Test
    void recthoekenMetVerschillendLengteOfBreedteZijnVerschillend() {
        assertThat(new Rechthoek(3,5)).isNotEqualTo(new Rechthoek(3,6));
    }
}