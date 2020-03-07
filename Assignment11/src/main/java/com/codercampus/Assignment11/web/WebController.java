package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.TransactionNew;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class WebController {
	@Autowired	
	TransactionService trServ;
		
	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
		 
		List<TransactionNew> sortedAndAdjustedList = trServ.adjustedList();
		TransactionNew transaction = new TransactionNew();
		
		model.put("transactionList", sortedAndAdjustedList);
		model.put("transaction", transaction);
			
		return "transactions";
		
		
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransactionId(@PathVariable Long transactionId, ModelMap model) {
		TransactionNew trans = trServ.findById(transactionId);
		System.out.println(trans.getId().toString());
		
		model.put("transaction", trans);
		
		return "transactionID";
	}
}
