package br.com.credsystem.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.credsystem.test.entity.Card;
import br.com.credsystem.test.entity.Customer;
import br.com.credsystem.test.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository repository;

	@Autowired
	CustomerService customerService;

	public List<Card> getAllCards() {
		List<Card> cardList = repository.findAll();

		if (cardList.size() > 0) {
			return cardList;
		} else {
			return new ArrayList<Card>();
		}
	}

	public List<Card> getCardByCustomerId(Integer customerId) throws Exception {
		Customer customer = customerService.getCustomerById(customerId);

		if (customer != null) {

			List<Card> card = repository.getByCustomer(customer);

			if (!card.isEmpty()) {
				return card;
			} else {
				throw new Exception("No card record exist for given id");
			}
		} else {
			throw new Exception("No constumer record exist");
		}
	}

	public Card createCard(Card entity) throws Exception {
		Card card = repository.save(entity);
		if (card.getCartao() != null) {
			card.setCustomer(entity.getCustomer());
			return card;
		} else {
			throw new Exception("This customer cannot be created");
		}
	}

	public Card updateCard(Card entity) throws Exception {
		Optional<Card> card = repository.findById(entity.getCartao());

		if (card.isPresent()) {
			Card newEntity = card.get();
			newEntity.setCartao(entity.getCartao());
			newEntity.setLimite(entity.getLimite());
			newEntity.setLimiteUtilizado(entity.getLimiteUtilizado());
			newEntity.setSenha(entity.getSenha());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteCardById(String nome) throws Exception {
		Optional<Card> card = repository.findById(nome);

		if (card.isPresent()) {
			repository.deleteById(nome);
		} else {
			throw new Exception("No customer record exist for given id");
		}
	}
}
