package be.vdab;

import java.time.LocalDate;

public class Periode {
    private final LocalDate van;
    private final LocalDate tot;

    public Periode(LocalDate van, LocalDate tot) {
        if(tot.isBefore(van)){
            throw new IllegalArgumentException();
        }
        this.van = van;
        this.tot = tot;
    }

    public boolean komtNa(Periode periode){
        return tot.isAfter(periode.van);
    }

    public boolean overlaptMet(Periode periode){
        return bevat(periode.van)||bevat(periode.tot);
    }
    public boolean bevat(LocalDate datum){
        return (datum.isEqual(van)||datum.isAfter(van))&&(datum.isEqual(tot)||datum.isBefore(tot));
    }
}
