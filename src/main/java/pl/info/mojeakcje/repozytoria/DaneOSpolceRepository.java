package pl.info.mojeakcje.repozytoria;

public interface DaneOSpolceRepository<DaneOSpolce, BigInteger> extends Repository<DaneOSpolce, BigInteger> {

    boolean containsInfo(String info);
}
