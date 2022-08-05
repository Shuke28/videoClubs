package uabc.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.City;
import uabc.demo.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepo;
	
	public List<Map> findByCountryId(Integer countryId){
		List<City> ciudades = cityRepo.findByCountryId(countryId);
		List<Map> c = ciudades.stream().map(item ->
			new HashMap<String, Object>(
					Map.of("id",item.getCityId(),"text",item.getCityName())
					)
				).collect(Collectors.toList());
		
		
		return c;
	}
}
