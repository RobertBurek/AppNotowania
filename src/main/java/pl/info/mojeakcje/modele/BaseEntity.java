package pl.info.mojeakcje.modele;

public class BaseEntity<T> extends Entity<T> {

    private T id;

    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
    }
}
