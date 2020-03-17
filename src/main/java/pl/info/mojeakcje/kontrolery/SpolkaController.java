package pl.info.mojeakcje.kontrolery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.info.mojeakcje.modele.Entity;
import pl.info.mojeakcje.modele.Spolka;
import pl.info.mojeakcje.serwisy.SpolkaService;
import pl.info.mojeakcje.valueobject.SpolkaVO;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Robert Burek
 */
@RestController
@RequestMapping("/v1/spolki")
public class SpolkaController {

    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(SpolkaController.class.getName());

    /**
     *
     */
    protected SpolkaService spolkaService;

    /**
     * @param spolkaService
     */
    @Autowired
    public SpolkaController(SpolkaService spolkaService) {
        this.spolkaService = spolkaService;
    }

    /**
     * Pobiera spolki o podanej nazwie. Częściowo bez rozróżniania wielkości liter.
     * Więc <code> http: //.../spolki/rest </code> znajdzie dowolne spółki zawierające
     * człon 'rest' lub 'REST' w nazwie.
     *
     * @param name
     * @return niepusta kolekcja spolki.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Spolka>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("spółka-service metoda findByName() wywołana: %s for %s ", spolkaService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<Spolka> spolki;
        try {
            spolki = spolkaService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Wyjątek metody findByName", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return spolki.size() > 0 ? new ResponseEntity<>(spolki, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Pobiera spółkę dla zadanego id.
     * <code>http://.../v1/spolki/{spolka_id}</code> zwróci
     * spółkę o zadanym id.
     *
     * @param id
     * @return obiekt spółki.
     */
    @RequestMapping(value = "/{spolka_id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("spolka_id") String id) {
        logger.info(String.format("spółka-service findById() wywołana: {} dla {} ", spolkaService.getClass().getName(), id));
        id = id.trim();
        Entity restaurant;
        try {
            restaurant = spolkaService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Wyjątek metody findById.", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return restaurant != null ? new ResponseEntity<>(restaurant, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Dodaje spółkę na podstawie określonych danych.
     *
     * @param spolkaVO
     * @return spółka z null wartościami.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Spolka> add(@RequestBody SpolkaVO spolkaVO) {
        logger.info(String.format("spólka-service add() invoked: %s for %s", spolkaService.getClass().getName(), spolkaVO.getName()));
        System.out.println(spolkaVO);
        Spolka spolka = new Spolka(null, null, null);
        BeanUtils.copyProperties(spolkaVO, spolka);
        try {
            spolkaService.add(spolka);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Wyjątek w dodawaniu spólki w metodzie add {0}", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
