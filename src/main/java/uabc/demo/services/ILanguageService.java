package uabc.demo.services;

import java.util.List;
import java.util.Optional;

import uabc.demo.entities.Language;

public interface ILanguageService {

	public Optional<Language> findById(Integer id);
	
	public List<Language> findAll();
}
