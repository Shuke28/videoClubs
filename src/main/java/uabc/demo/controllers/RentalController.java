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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import uabc.demo.entities.Country;
import uabc.demo.entities.Customer;
import uabc.demo.entities.Inventory;
import uabc.demo.entities.Film;
import uabc.demo.entities.Rental;
import uabc.demo.services.FilmService;
import uabc.demo.services.InventoryService;
import uabc.demo.services.RentalService;

@Controller
public class RentalController {
	
	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private FilmService filmService;  
	

	@GetMapping(value="rental")
	public String rental(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		List<Rental> listaRentals = rentalService.findAll();
	
		model.addAttribute("rentals", listaRentals);
		

		return "views/renta/rental";
	}
	
	@PostMapping("/saveRental")
	public String saveRental(@Validated Rental rental, Errors errors) {
		if(errors.hasErrors()) {
			return "redirect:/";
		}
		
		rental.setCustomerId(rental.getCustomerId());
		rental.setStaffId((int)1);
		rental.setInventoryId(rental.getInventoryId());
		rental.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		rental.setRentalDate(new Timestamp(System.currentTimeMillis()));
		rental.setReturnDate(null);
		rentalService.rentalSave(rental);
		return "views/renta/rental";
	}
	

	
	@GetMapping(value="detallesRentalInventory/{inventoryId}")
	@ResponseBody
	public Map<String, Object> loadInventory(@PathVariable Integer inventoryId){
		Map<String, Object> response = new HashMap<>();
		
		Inventory inventory = inventoryService.findByInventoryId(inventoryId);/*.get();*/
		
		response.put("details", inventory);
		
		return response;
	}
}


