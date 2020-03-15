package pl.info.mojeakcje.serwis;

import pl.info.mojeakcje.model.Spolka;
import pl.info.mojeakcje.repozytoria.SpolkaRepository;

import java.math.BigInteger;
import java.util.Collection;

public class SpolkaService extends BaseService<Spolka, BigInteger> {

    private SpolkaRepository<Spolka, String> spolkaRepository;

    public SpolkaService(SpolkaRepository repository) {
        super(repository);
        spolkaRepository = repository;
    }

    @Override
    public void add(Spolka spolka) throws Exception {
        if (spolkaRepository.containsName(spolka.getName())) {
            throw new Exception(String.format("Spółka o takiej nazwie już istnieje - %s", spolka.getName()));
        }

        if (spolka.getName() == null || "".equals(spolka.getName())) {
            throw new Exception("Nazwa spółki nie może być pusta ani równa null.");
        }
        super.add(spolka);
    }

    @Override
    public Collection<Spolka> getAll() {
        return super.getAll();
    }
}
