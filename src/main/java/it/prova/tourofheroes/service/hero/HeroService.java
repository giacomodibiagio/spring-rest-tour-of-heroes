package it.prova.tourofheroes.service.hero;

import it.prova.tourofheroes.model.Hero;

import java.util.List;

public interface HeroService {

    public List<Hero> listAll();

    public Hero caricaSingoloElemeno(Long id);

    public Hero aggiorna(Hero heroInstance);

    public Hero inserisciNuovo(Hero heroInstance);

    public void rimuovi(Hero heroInstance);


}
