package be.vdab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class VeilingTest {
    private Veiling veiling;

    @BeforeEach
    void beforeEach() {
        veiling = new Veiling();
    }

    @Test
    void geenBodUitgebrachtHetHoogsteBodIs0() {
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    void eenBod1000HetHoogsteBodIs1000() {
        veiling.doeBod(BigDecimal.valueOf(1000));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("1000");
    }

    @Test
    void tweeBoden1000En500HetHoogsteBodIs1000() {
        veiling.doeBod(BigDecimal.valueOf(1000));
        veiling.doeBod(BigDecimal.valueOf(500));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("1000");
    }

    @Test
    void drieBoden1000En500En2000HetHoogsteBodIs2000() {
        veiling.doeBod(BigDecimal.valueOf(1000));
        veiling.doeBod(BigDecimal.valueOf(500));
        veiling.doeBod(BigDecimal.valueOf(2000));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("2000");
    }
}