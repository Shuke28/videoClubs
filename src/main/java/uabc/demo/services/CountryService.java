package uabc.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.Country;
import uabc.demo.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepo;
	
	public List<Country> findAll(){
		return countryRepo.findAll();
	}
}
