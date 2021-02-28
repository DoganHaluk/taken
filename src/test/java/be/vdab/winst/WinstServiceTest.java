package be.vdab.winst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class WinstServiceTest {
    private WinstService winstService;
    @BeforeEach
    void beforeEach(){
        winstService=new WinstService(new OpbrengstRepositoryStub(),new KostRepositoryStub());
    }
    @Test
    void winstIsOpbrengstMinKost(){
        assertThat(winstService.getWinst()).isEqualByComparingTo("31");
    }
}