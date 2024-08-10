package com.banking.Bank.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.banking.Bank.Model.CustomerTransaction;
import com.banking.Bank.Services.TransactionService;
import com.banking.Bank.repository.CustomerRepository;
import com.banking.Bank.repository.TransactionRepository;

@Controller
@RequestMapping
@SessionAttributes("name")
public class BankCustomerController {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TransactionRepository tr;
	@Autowired
	TransactionService ts;
	Long accno;
	@GetMapping("/validateLogin")
	public String showIndexPage(ModelMap m) {
				
		return "index";
	}

	
	  @PostMapping("/validateLogin") public String validateLogin(ModelMap m, @RequestParam Long accountnumber) { 
		  boolean b =
	  customerRepository.existByAccountNumber(accountnumber); if(b == false) {
		  m.put("error","Wrong Credentials");
			return "errors";
	  
	  }
	  accno=accountnumber;
	  m.put("accountnumber",accountnumber);
	  
	  return "validated";
	  
	  }
	 
	
	@GetMapping("/customer/checkbal/{accountnumber}")
	public String checkBalence( ModelMap m , @PathVariable("accountnumber") Long accountnumber) {
		
		double a = customerRepository.findById(accountnumber).get().getAccountBalance();
		m.put("checkbalance", a);
		return "checkBalence";
		
	}
	@GetMapping("/customer/home/{accountnumber}")
	public String home( ModelMap m , @PathVariable("accountnumber") Long accountnumber) {
		
		
		return "home";
		
	}
	@GetMapping("/customer/deposit/{accountnumber}")
	public String doDeposit(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		m.put("accountnumber",accountnumber);
		
		return "deposit";
		
	}
	@PostMapping("/customer/deposit/{accountnumber}")
	public String amountDeposit(ModelMap m, @PathVariable("accountnumber")
	Long accountnumber, @RequestParam("deposit") Double 
			deposit) {
		System.out.print("dep"+deposit+accountnumber);
		m.put("accountnumber",accountnumber);
		m.put("deposit",deposit);
		ts.transfer(accountnumber, accountnumber, deposit);
		
		
		
		return "depositmsg";
		
	}
	@GetMapping("/customer/transfer/{accountnumber}")
	public String doTransfer(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		m.put("accountnumber",accountnumber);
		return "transfer";
		
	}
	@PostMapping("/customer/transfer/{accountnumber}")
	public String amountTransfer(ModelMap m, @PathVariable("accountnumber")
	
	Long accountnumber, @RequestParam("deposit") Double 
	deposit, @RequestParam("toaccount") Long toaccount) {
		if (!customerRepository.existByAccountNumber(toaccount)) {
			m.put("error", "Account not found");
			return "errors";
		}
		if (customerRepository.findById(accountnumber).get().getAccountBalance() < deposit) {
			m.put("error","Insufficient Balance");
			return "errors";
			
		}
		if(customerRepository.existByAccountNumber(toaccount) && 
				customerRepository.existByAccountNumber(accountnumber) 
				&& customerRepository.findById(accountnumber).get().getAccountBalance() > deposit) {
		m.put("accountnumber",accountnumber);
		m.put("deposit",deposit);
		ts.transfertoOther(accountnumber, toaccount, deposit);
		
		
		
		return "depositmsg";
		}
		m.put("error","Validation Falure");
		return "errors";
		
	}
	@GetMapping("/customer/withdraw/{accountnumber}")
	public String doWithDrawl(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		m.put("accountnumber",accountnumber);
		return "withdraw";
		
	}
	@PostMapping("/customer/withdraw/{accountnumber}")
	public String amountWithDrawl(ModelMap m, @PathVariable("accountnumber")
	Long accountnumber, @RequestParam("withdraw") Double withdraw) {
		
		m.put("accountnumber",accountnumber);
		m.put("withdraw",withdraw);
		
		if (customerRepository.findById(accountnumber).get().getAccountBalance() < withdraw) {
			m.put("error","Insufficient Balance");
			return "errors";
			
		}
		
		ts.withdrawl(accountnumber, accountnumber, withdraw);
		return "withdrawmsg";
		
	}
	@GetMapping("/customer/logout")
	public String dologout() {
		
		return "index";
		
	}
	
	@GetMapping("/customer/recent/{accountnumber}")
	public String recentTransaction(@PathVariable("accountnumber") Long accountnumber, ModelMap m) {
		
		m.put("accountnumber",accountnumber);
		//write code for recent transaction
		List<CustomerTransaction> o = ts.getRecentTransaction(accountnumber);
		//System.out.print(o);
		m.put("recent",o);

		
		
		return "recent";
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) 
	{
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	

}
