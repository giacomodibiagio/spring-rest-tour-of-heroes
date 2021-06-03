package it.prova.tourofheroes.service.hero;

import it.prova.tourofheroes.model.Hero;
import it.prova.tourofheroes.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository repository;

    @Override
    public List<Hero> listAll() {
        return (List<Hero>) repository.findAll();
    }

    @Override
    public Hero caricaSingoloElemeno(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Hero aggiorna(Hero heroInstance) {
        return repository.save(heroInstance);
    }

    @Override
    public Hero inserisciNuovo(Hero heroInstance) {
        return repository.save(heroInstance);
    }

    @Override
    public void rimuovi(Hero heroInstance) {
        repository.delete(heroInstance);
    }
}
