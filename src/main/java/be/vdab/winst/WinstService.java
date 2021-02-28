package be.vdab.winst;

import be.vdab.winst.KostRepository;
import be.vdab.winst.OpbrengstRepository;

import java.math.BigDecimal;

public class WinstService {
    private final OpbrengstRepository opbrengstRepository;
    private final KostRepository kostRepository;

    public WinstService(OpbrengstRepository opbrengstRepository, KostRepository kostRepository) {
        this.opbrengstRepository = opbrengstRepository;
        this.kostRepository = kostRepository;
    }

    public BigDecimal getWinst(){
        return opbrengstRepository.findTotaleOpbrengst().subtract(kostRepository.findTotaleKost());
    }
}
