package pl.info.mojeakcje.repozytoria;

import pl.info.mojeakcje.model.DaneDzienne;

import java.math.BigInteger;

public interface DaneDzienneRepository<DaneDzienne, BigInteger> extends Repository<DaneDzienne, BigInteger> {

    boolean containsInfo(String info);
}
