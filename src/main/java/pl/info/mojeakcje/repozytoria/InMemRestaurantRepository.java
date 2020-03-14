package pl.info.mojeakcje.repozytoria;

import pl.info.mojeakcje.model.Spolka;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh Sharma
 */
public class InMemRestaurantRepository implements SpolkaRepository<Spolka, String> {
    private Map<String, Spolka> entities;

    public InMemRestaurantRepository() {
        entities = new HashMap();
    }

    @Override
    public boolean containsName(String name) {
        return entities.containsKey(name);
    }

    @Override
    public void add(Spolka entity) {
        entities.put(entity.getName(), entity);
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    @Override
    public void update(Spolka entity) {
        if (entities.containsKey(entity.getName())) {
            entities.put(entity.getName(), entity);
        }
    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Metoda nie została zaimplementowana.");
        // Aby zmienić treść generowanych metod, wybierz opcję Tools/Templates.
    }

    @Override
    public Spolka get(String id) {
        throw new UnsupportedOperationException("Metoda nie została zaimplementowana.");
        // Aby zmienić treść generowanych metod, wybierz opcję Tools/Templates.
    }

    @Override
    public Collection<Spolka> getAll() {
        return entities.values();
    }

}
