package uabc.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.Actor;
import uabc.demo.entities.Address;
import uabc.demo.entities.Film;
import uabc.demo.entities.FilmActor;
import uabc.demo.entities.FilmCategory;
import uabc.demo.entities.Language;
import uabc.demo.repository.ActorRepository;
//import uabc.demo.repository.FilmActorRepository;
import uabc.demo.repository.FilmActorRepository;

@Service
public class ActorService {
	
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private FilmActorRepository filmActorRepository;
	
	
	public List<Actor> findAll() {
		return actorRepository.findAll();
	}
	
	////////////////////////////////////
	@Transactional
	public void filmActorSave(FilmActor fActor) {
		filmActorRepository.save(fActor);
	}
	
	@Transactional
	public void guardarFilmActor(FilmActor fActor) {
		filmActorRepository.guardarFilmActor(fActor.getFilmId(),fActor.getActorId()) ;
	}
	///////////////////////////////////
}
