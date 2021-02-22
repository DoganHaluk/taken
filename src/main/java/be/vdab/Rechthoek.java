package be.vdab;

import java.util.Objects;

public class Rechthoek {
    private final int lengte;
    private final int breedte;

    public Rechthoek(int lengte, int breedte) {
        if (lengte < 0 || breedte < 0 || lengte < breedte) {
            throw new IllegalArgumentException();
        } else {
            this.lengte = lengte;
            this.breedte = breedte;
        }
    }

    public int getOppervlakte() {
        return lengte * breedte;
    }

    public int getOmtrek() {
        return 2 * (lengte + breedte);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rechthoek) {
            var anderRechthoek = (Rechthoek) obj;
            return lengte == anderRechthoek.lengte && breedte == anderRechthoek.breedte;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengte, breedte);
    }
}
