package uabc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.demo.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
