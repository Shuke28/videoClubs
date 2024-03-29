package uabc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uabc.demo.entities.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	List<City> findByCountryId(Integer countryId);
}
