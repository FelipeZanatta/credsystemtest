package br.com.credsystem.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.credsystem.test.entity.Customer;
import br.com.credsystem.test.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;

	public List<Customer> getAllCostumers() {
		List<Customer> customerList = repository.findAll();

		if (customerList.size() > 0) {
			return customerList;
		} else {
			return new ArrayList<Customer>();
		}
	}

	public Customer getCustomerById(Integer id) throws Exception {
		Optional<Customer> customer = repository.findById(id);

		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new Exception("No customer record exist for given id");
		}
	}

	public Customer createOrUpdateCustomer(Customer entity) throws Exception {
		Optional<Customer> customer = repository.findById(entity.getId());

		if (customer.isPresent()) {
			Customer newEntity = customer.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setNome(entity.getNome());
			newEntity.setSalario(entity.getSalario());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteCustomerById(Integer id) throws Exception {
		Optional<Customer> customer = repository.findById(id);

		if (customer.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No customer record exist for given id");
		}
	}
}
