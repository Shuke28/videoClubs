package uabc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uabc.demo.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value = "SELECT first_name, last_name, email FROM customer WHERE  first_name  = ?1 AND last_name = ?2 AND email = ?3", nativeQuery = true)
	String validarCustomer(String firstName, String lastName, String email);
	
}
