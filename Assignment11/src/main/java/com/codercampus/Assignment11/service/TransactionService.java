package com.codercampus.Assignment11.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.domain.TransactionNew;

@Service
public class TransactionService {
	@Autowired
	SortedList sl;
	
	List<TransactionNew> newList = new ArrayList<>(100);
	
	public TransactionNew findById(Long id) {
		List<TransactionNew> collect = newList.stream().filter(o -> o.getId().equals(id)).collect(Collectors.toList());
		TransactionNew trans = collect.get(0);
		return trans;
	}
	
	public List<TransactionNew> adjustedList() {
		List<Transaction> sortedList = sl.sortedByDate();
		
		for (Transaction trans : sortedList) {
			Long id = trans.getId();
			LocalDateTime date = trans.getDate();
			String retailer = trans.getRetailer();
			BigDecimal fundsIn;
			BigDecimal fundsOut;
			String type;
			BigDecimal amount = trans.getAmount();
			String description = trans.getDescription();
			
			if(trans.getType().contains("D")) {
				fundsIn = null;
				fundsOut = trans.getAmount();
				type = "Debit";
			} else { 
				fundsIn = trans.getAmount();
				fundsOut = null;
				type = "Credit";
			}
			TransactionNew newTrans = new TransactionNew(id, date, retailer, fundsIn, 
					fundsOut, type, amount, description);
			newList.add(newTrans);
			System.out.println(newTrans.toString());
		}
		return newList;
	}
}
