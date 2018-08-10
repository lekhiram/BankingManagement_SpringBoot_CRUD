package com.example.Springbootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Springbootcrud.model.Bank;
import com.example.Springbootcrud.repository.BankRepo;

@Service
public class BankService {

	@Autowired
	BankRepo repo;

	@Transactional(readOnly = true)
	public Bank getBank(Integer bankId) {
		return repo.getOne(bankId);
	}

	@Transactional
	public Bank createBank(Bank objBank) {
		return repo.save(objBank);
	}

	@Transactional
	public String deleteBank(Integer BankId) {
		repo.deleteById(BankId);
		return "Successfully deleted for id=" + BankId;
	}

	@Transactional
	public Bank updateBank(Bank objBank) {
		return repo.save(objBank);

	}

	@Transactional
	public int deleteSecondHigheestBank() {
		return repo.deleteSecondHighestId();
	}

	public List<Bank> getAllBanks() {

		return repo.findAll();
	}

}
