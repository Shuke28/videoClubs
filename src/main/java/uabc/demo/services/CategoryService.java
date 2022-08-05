package uabc.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.Category;
import uabc.demo.entities.FilmCategory;
import uabc.demo.repository.CategoryRepository;
import uabc.demo.repository.FilmCategoryRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	///////////////////////////////////////////////////////
	@Autowired
	private FilmCategoryRepository filmCategoryRepository;
	//////////////////////////////////////////////////////
	
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Optional<Category> findById(Integer id){
		return categoryRepository.findById(id);
	}
	
	////////////////////////////////////
	@Transactional
	public void filmCategorySave(FilmCategory fCategory) {
		filmCategoryRepository.save(fCategory);
	}
	
	@Transactional
	public void guardarFilmCategoria(FilmCategory fCategory) {
		filmCategoryRepository.guardarFilmCategoria(fCategory.getFilmId(),fCategory.getCategoryId()) ;
	}
	
	
	///////////////////////////////////
	
}
