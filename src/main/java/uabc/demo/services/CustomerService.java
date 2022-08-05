package uabc.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.Customer;
import uabc.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Transactional
	public void customerSave(Customer customer) {
		customerRepo.save(customer);
	}
	

	public Customer buscarId (Integer id) {
		return customerRepo.findById(id).get();
	}

	public List<Customer> findAll(){
		return customerRepo.findAll();

	}
	
	public String validarCustomer(String firstName, String lastName, String email){
		return customerRepo.validarCustomer(firstName, lastName, email);
	}
	
	@Transactional
	public void eliminarCustomer(Customer customer) {
		customerRepo.delete(customer);
	}
}
