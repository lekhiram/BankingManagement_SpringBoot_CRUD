package com.example.Springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springbootcrud.model.Bank;
import com.example.Springbootcrud.service.BankService;
import com.google.common.net.MediaType;

@RestController
@RequestMapping("/api")
public class BankController {

	@Autowired
	BankService service;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Bank createBank(@RequestBody Bank obj) {

		System.out.println("obj=" + obj.getName());
		return service.createBank(obj);
	}

	@GetMapping("/{Bankid}")
	public Bank getBankById(@PathVariable("Bankid") Integer sid) {
		System.out.println("Bankid=" + sid);
		return service.getBank(sid);
	}

	@PutMapping(consumes = "application/json")
	public Bank updateBank(@RequestBody Bank obj) {

		System.out.println("obj=" + obj.getName());
		return service.updateBank(obj);

	}

	@DeleteMapping("/{Bankid}")
	public String deleteBankById(@PathVariable("Bankid") Integer sid) {
		return service.deleteBank(sid);

	}

	@DeleteMapping(produces = "application/json")
	public int deleteSecondHighest() {
		return service.deleteSecondHigheestBank();
	}

	@GetMapping(produces = "application/json")
	public List<Bank> getAllBanks() {

		return service.getAllBanks();
	}

	

}
