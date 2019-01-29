package fr.m2i.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.m2i.tp.entity.Customer;

public interface DaoCustomer extends CrudRepository<Customer, Long> {

	public Customer findByUsername(String username);
}
