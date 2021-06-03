package it.prova.tourofheroes.repository.hero;

import it.prova.tourofheroes.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface HeroRepository extends CrudRepository<Hero, Long> {

}
