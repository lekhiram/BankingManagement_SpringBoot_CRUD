package com.example.Springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Springbootcrud.model.Bank;

@Repository
public interface BankRepo extends JpaRepository<Bank, Integer> {

	@Transactional
	@Modifying
	@Query("delete from Bank where id in" + "(select max(id) from Bank where "
			+ "id not in(select max(id) from Bank))")
	public int deleteSecondHighestId();
}
