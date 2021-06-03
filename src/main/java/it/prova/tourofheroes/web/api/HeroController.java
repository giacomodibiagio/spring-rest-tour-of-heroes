package it.prova.tourofheroes.web.api;

import it.prova.tourofheroes.model.Hero;
import it.prova.tourofheroes.service.hero.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("hero")
public class HeroController {
    @Autowired
    private HeroService service;

    @GetMapping("/all")
    public ResponseEntity<List<Hero>> getAll () {
        List<Hero> heroes = service.listAll();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Hero> get (@PathVariable("id") Long id) {
        Hero hero = service.caricaSingoloElemeno(id);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Hero> add (@Valid @RequestBody Hero hero) {
       Hero heroInstance = service.inserisciNuovo(hero);
        return new ResponseEntity<>(heroInstance, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hero> update(@Valid @RequestBody Hero hero, @PathVariable("id") Long id) {
        hero.setId(id);
        service.aggiorna(hero);
        Hero heroModificato = hero;
        return new ResponseEntity<>(heroModificato, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.rimuovi(service.caricaSingoloElemeno(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
