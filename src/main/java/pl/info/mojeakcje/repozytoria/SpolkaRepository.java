package pl.info.mojeakcje.repozytoria;

public interface SpolkaRepository<Spolka, String> extends Repository<Spolka, String> {

    boolean containsName(String name);
}
