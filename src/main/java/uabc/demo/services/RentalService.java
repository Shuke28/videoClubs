package uabc.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.Country;
import uabc.demo.entities.Customer;
import uabc.demo.entities.Rental;
import uabc.demo.repository.RentalRepository;



@Service
public class RentalService {
	@Autowired
	private RentalRepository rentalRepository;
	
	
	@Transactional
	public void rentalSave(Rental rental) {
		rentalRepository.save(rental);
	}
	
	public List<Rental> findAll(){
		return rentalRepository.findAll();

	}

}
