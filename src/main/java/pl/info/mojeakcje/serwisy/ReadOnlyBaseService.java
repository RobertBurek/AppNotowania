package pl.info.mojeakcje.serwisy;

import pl.info.mojeakcje.repozytoria.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }

}
