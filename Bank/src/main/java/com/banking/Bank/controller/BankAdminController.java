package com.banking.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.banking.Bank.Model.CustomerDetails;
import com.banking.Bank.repository.CustomerRepository;

@Controller
@RequestMapping("/bank/admin/")
public class BankAdminController {
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/home")
	public String adminHome() {
		
		return "adminhome";
		
	}
	@RequestMapping("/login")
	public String adminlogin() {
		return "adminlogin";
		
	}
	@RequestMapping("/logout")
	public String adminlogout() {
		return "index";
		
	}
	@RequestMapping("/adminportal")
	public String adminPortal() {
		return "adminfunction";
		
	}
	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new CustomerDetails());
		return "addCustomer";
		
	}
	@PostMapping("/addCustomers")
	public String submitaddCustomer(@ModelAttribute CustomerDetails customer) {
		customerRepository.save(customer);
		return "message";
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) 
	{
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

}
