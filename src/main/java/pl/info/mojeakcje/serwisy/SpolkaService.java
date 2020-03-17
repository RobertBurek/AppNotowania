package pl.info.mojeakcje.serwisy;

import pl.info.mojeakcje.modele.Entity;
import pl.info.mojeakcje.modele.Spolka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Robert Burek
 */
public interface SpolkaService {

    /**
     * @param spolka
     * @throws Exception
     */
    public void add(Spolka spolka) throws Exception;

    /**
     * @param spolka
     * @throws Exception
     */
    public void update(Spolka spolka) throws Exception;

    /**
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     * @param spolkaId
     * @return
     * @throws Exception
     */
    public Entity findById(String spolkaId) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Spolka> findByName(String name) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Spolka> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
