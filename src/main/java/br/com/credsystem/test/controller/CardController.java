package br.com.credsystem.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.credsystem.test.entity.Card;
import br.com.credsystem.test.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private CardService service;

	@GetMapping("/all")
	public ResponseEntity<List<Card>> getAllCards() {
		List<Card> list = service.getAllCards();

		return new ResponseEntity<List<Card>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Card>> getCardByCustomerId(@PathVariable("id") Integer customer) throws Exception {

		List<Card> entity = service.getCardByCustomerId(customer);

		return new ResponseEntity<List<Card>>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Card> createCard(@RequestBody Card card) throws Exception {

		Card create = service.createCard(card);
		return new ResponseEntity<Card>(create, new HttpHeaders(), HttpStatus.OK);
	}

//	@PutMapping("/{cartao}")
//	public ResponseEntity<Card> updateCard(@RequestBody Card card) throws Exception {
//
//		Card updated = service.updateCard(card);
//		return new ResponseEntity<Card>(updated, new HttpHeaders(), HttpStatus.OK);
//	}
//
//	@DeleteMapping("/{cartao}")
//	public HttpStatus deleteCustomerById(@PathVariable("cartao") String cartao) throws Exception {
//
//		service.deleteCardById(cartao);
//		return HttpStatus.FORBIDDEN;
//	}

}
