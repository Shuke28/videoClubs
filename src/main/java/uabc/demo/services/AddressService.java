package uabc.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.Address;
import uabc.demo.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Transactional
	public void saveAddress(Address address) {
		addressRepo.save(address);
	}
}
