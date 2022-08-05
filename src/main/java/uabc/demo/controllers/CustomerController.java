package uabc.demo.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import uabc.demo.entities.Address;
import uabc.demo.entities.Country;
import uabc.demo.entities.Customer;
import uabc.demo.services.AddressService;
import uabc.demo.services.CityService;
import uabc.demo.services.CountryService;
import uabc.demo.services.CustomerService;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping(value="customer")
	public String cuatomer(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		List<Country> paises = countryService.findAll();
		List<Customer> listaCustomers = customerService.findAll();
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("countries", paises);
		model.addAttribute("customers", listaCustomers);
		
		return "views/customer/customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer, Errors errors) {
		if(errors.hasErrors()) {
			return "redirect:/";
		}
		Address address = new Address();
		
		address.setCityId(customer.getCityId());
		address.setName(customer.getAddress());
		address.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		addressService.saveAddress(address);
		Integer addressId = address.getAddressId();
		
		customer.setActiveBool((boolean)true);
		customer.setCreateDate(new Date());
		customer.setAddressId(addressId);
	 	customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customer.setActive((int)1);
		
		String customerValid = customerService.validarCustomer(customer.getFirstName(), customer.getLastName(), customer.getEmail());
		String customerNew = customer.getFirstName() + "," + customer.getLastName() + "," + customer.getEmail() ;
		if(customerValid == null) customerValid="0,0,0";
		if(customerValid.equals(customerNew)) {
			return errors.getObjectName();
		
		}else{
			
			customerService.customerSave(customer);
		}
		
		return "views/customer/customer";
		 
	}
	
	@GetMapping(value="detallesCustomer/{customerId}")
	@ResponseBody
	public Map<String, Object> loadCostumer(@PathVariable Integer customerId){
		Map<String, Object> response = new HashMap<>();
		response.put("details", customerService.buscarId(customerId));
		return response;
	}

	@ResponseBody
	@GetMapping(value = "/ciudadesPorPais/{id}")
	public List<Map> ciudadesPais(@PathVariable Integer id){
		return cityService.findByCountryId(id);

	}

	@PostMapping(value = "/eliminarCustomer")
	public String eliminarCustomer(Customer customer) {
		customerService.eliminarCustomer(customer);
		return "redirect:/";
	}

}


