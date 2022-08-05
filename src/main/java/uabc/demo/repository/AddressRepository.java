package uabc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uabc.demo.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}
