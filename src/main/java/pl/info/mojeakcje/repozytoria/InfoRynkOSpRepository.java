package pl.info.mojeakcje.repozytoria;

public interface InfoRynkOSpRepository<InfoRynkoweOSpolce, BigInteger> extends Repository<InfoRynkoweOSpolce, BigInteger> {

    boolean containsInfo(String info);
}
