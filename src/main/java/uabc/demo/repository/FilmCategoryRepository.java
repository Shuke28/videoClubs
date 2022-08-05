package uabc.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import uabc.demo.entities.FilmCategory;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Integer>{

	
	@Query(value ="INSERT INTO public.film_category "
			+ "(film_id, category_id, last_update) "
			+ "VALUES(?1, ?2, now())" , nativeQuery=true)
	@Modifying
	@Transactional
	Integer guardarFilmCategoria(Integer filmId,Integer categoryId);
	
}
