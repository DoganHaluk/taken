import org.assertj.core.api.PredicateAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PeriodeTest {
    private LocalDate datum1;
    private LocalDate datum2;
    private Periode periode1;
    private Periode periode2;

    @BeforeEach
    void beforeEach() {
        datum1 = LocalDate.of(2021, 1, 1);
        datum2 = LocalDate.of(2021, 2, 28);
        periode1 = new Periode(datum1, datum2);
        periode2 = new Periode(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 2, 28));
    }

    @Test
    void vanMoetIngevuldZijn() {
        assertThatNullPointerException().isThrownBy(() -> new Periode(null, datum1));
    }

    @Test
    void totMoetIngevuldZijn() {
        assertThatNullPointerException().isThrownBy(() -> new Periode(datum2, null));
    }

    @Test
    void totMoetGroterOfGelijkZijnAanVan() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Periode(datum2, datum1));
    }

    @Test
    void eenPeriodeVanEenDagIsOK() {
        new Periode(datum1, datum1);
    }

    @Test
    void periodeInKomtNaMoetIngevuldZijn() {
        assertThatNullPointerException().isThrownBy(() -> periode1.komtNa(null));
    }

    @Test
    void eenPeriodeKomtNaEenPeriodeDieOuderIs() {
        assertThat(periode2.komtNa(periode1)).isTrue();
    }

    @Test
    void eenPeriodeKomtNietNaEenPeriodeDieJongerIs() {
        assertThat(periode1.komtNa(periode2)).isFalse();
    }

    @Test
    void eenPeriodeKomtNietNaEenPeriodeMetGelijkeVans() {
        assertThat(new Periode(LocalDate.of(2019, 1, 9), LocalDate.of(2019, 1, 10)).komtNa(periode1)).isFalse();
    }

    @Test
    void eenPeriodeOverlaptMetZichzelf() {
        assertThat(periode1.overlaptMet(periode1)).isTrue();
    }

    @Test
    void eenPeriodeOverlaptNietMetEenPeriodeNaDeEerstePeriode() {
        assertThat(periode1.overlaptMet(periode2)).isFalse();
    }

    @Test
    void eenPeriodeOverlaptNietMetEenPeriodeVoorDeEerstePeriode() {
        assertThat(periode2.overlaptMet(periode1)).isFalse();
    }

    @Test
    void eenPeriodeOverlaptMetEenPeriodeMetEenVanInDeEerstePeriode() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2019, 1, 2), LocalDate.of(2019, 1, 15)))).isTrue();
    }

    @Test
    void eenPeriodeOverlaptMetEenPeriodMetEenTotInDeEerstePeriode() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2018, 12, 31), LocalDate.of(2019, 1, 5)))).isTrue();
    }

    @Test
    void eenPeriodeOverlaptMetEenPeriodeDieHelemaalInDeEerstePeriodeLigt() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2019, 1, 2), LocalDate.of(2019, 1, 3)))).isTrue();
    }

    @Test
    void eenPeriodeOverlaptMetEenPeriodeMetGelijkeVans() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 2, 28)))).isTrue();
    }

    @Test
    void eenPeriodeOverlaptMetEenPeriodeMetGelijkeTots() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 2, 28)))).isTrue();
    }
}