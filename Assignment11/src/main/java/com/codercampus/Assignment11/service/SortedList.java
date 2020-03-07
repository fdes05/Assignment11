package com.codercampus.Assignment11.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class SortedList {

	@Autowired
	TransactionRepository tr;
	
	List<Transaction> sortedTransactions = new ArrayList<>(100);
	
	public List<Transaction> sortedByDate() {
		
		TransactionRepository tr = new TransactionRepository();
		List<Transaction> findAll = tr.findAll();
		Transaction[] transaction = findAll.toArray(new Transaction[100]);
		Arrays.sort(transaction, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o1.getDate().compareTo(o2.getDate());
				
			}});
		for (Transaction sorted : transaction) {
			sortedTransactions.add(sorted);
		}
		return sortedTransactions;
	}

			
}
