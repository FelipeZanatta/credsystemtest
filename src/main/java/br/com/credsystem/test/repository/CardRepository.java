package br.com.credsystem.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.credsystem.test.entity.Card;
import br.com.credsystem.test.entity.Customer;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
	
	 public List<Card> getByCustomer(Customer customer);
	
}
