package uabc.demo.controllers;

import java.security.Principal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.Errors;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import uabc.demo.entities.Actor;
import uabc.demo.entities.Category;

import uabc.demo.entities.Film;
import uabc.demo.entities.FilmActor;
import uabc.demo.entities.FilmCategory;
import uabc.demo.entities.Inventory;
import uabc.demo.entities.Language;
import uabc.demo.entities.Staff;
import uabc.demo.repository.FilmRepository;
import uabc.demo.repository.StaffRepository;
import uabc.demo.services.ActorService;
import uabc.demo.services.CategoryService;
import uabc.demo.services.FilmService;
import uabc.demo.services.IFilmService;
import uabc.demo.services.InventoryService;
import uabc.demo.services.LanguageService;

@Controller
public class RegistroPeliculasController {
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private FilmService fService;

	@Autowired
	private LanguageService lanService;
	
	@Autowired
	private InventoryService inventoryService;
	
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	
	@GetMapping(value="RegistroPeliculas")
	public String RegistroDePeliculas(Model model, HttpServletRequest request, HttpServletResponse response) {

		FilmCategory fCategory = new FilmCategory();
		
		

		List<Language> lenguajes = lanService.findAll();
		
		List<Actor> actors = actorService.findAll();
		
		List<Category> categories = categoryService.findAll();
	
		
		model.addAttribute("film", new Film());
		

		model.addAttribute("languages", lenguajes );
		model.addAttribute("actors", actors );
		model.addAttribute("categories", categories );
		
	
		return "views/registroPeliculasMax/RegistroPeliculas";
		
	}
	
	@PostMapping("/saveFilm")
	public String saveFilm(Film film, Inventory inventory, Errors errors, Principal principal,HttpServletRequest request) {
		
		Map<String, String[]> v =request.getParameterMap();
		
		//------------CATEGORIAS / ACTORES------------//
		String[] categories = v.get("categories");
		
		String[] actors = v.get("actors");
		//------------CATEGORIAS------------//
		
		
		film.setLast_update(new Timestamp(System.currentTimeMillis()));
		
		if(fService.findByName(film) != null) {
			return "views/error"; //ERROR
		}
		
		film = fService.filmSave(film);
		
		
		
		
		
		String[] strarr=principal.getName().split("@");

		Staff staff = staffRepository.findByUsername(strarr[0]);
		
		//Model model, HttpServletRequest request, HttpServletResponse response,
		
		
		//------------ NUMERO DE COPIAS ------------//
		
		for(int i = 0; i < Integer.parseInt(v.get("numeroCopias")[0]) ; i++){
		      
			inventory.setFilm(film);
			inventory.setStoreId(staff.getStoreId());
			inventory.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			inventoryService.inventorySave(inventory);
			
			
	    }
	    
		
		//------------CATEGORIAS------------//
		for (String sCategory : categories) {
			
			FilmCategory fCategory = new FilmCategory();
			
			
			System.out.println(sCategory);
			
			fCategory.setCategoryId(Integer.parseInt(sCategory));
			fCategory.setFilmId(film.getFilmId());
			
	
			fCategory.setLastUpdate(new java.util.Date());
			categoryService.guardarFilmCategoria(fCategory);
			
			//categoryService.filmCategorySave(fCategory);
			
		}
		
		
		//------------ACTORES------------//
		
		for (String sActor : actors) {
			
			
			FilmActor fActor = new FilmActor();
			
			System.out.println(sActor);
			
			fActor.setActorId(Integer.parseInt(sActor));
			fActor.setFilmId(film.getFilmId());
			
			fActor.setLastUpdate(new java.util.Date());
			actorService.guardarFilmActor(fActor);
			
		}
		
		
		return "views/RegistroPeliculasMax/RegistroExitoso";
		
	}
	
	
	
}