package uabc.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import uabc.demo.entities.FilmActor;

public interface FilmActorRepository extends JpaRepository<FilmActor, Integer>{
	
	
	@Query(value ="INSERT INTO public.film_actor "
			+ "(film_id, actor_id, last_update) "
			+ "VALUES(?1, ?2, now())" , nativeQuery=true)
	@Modifying
	@Transactional
	Integer guardarFilmActor(Integer filmId,Integer ActorId);

}

