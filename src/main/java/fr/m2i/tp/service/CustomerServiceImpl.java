package fr.m2i.tp.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.tp.dao.DaoCustomer;
import fr.m2i.tp.entity.Customer;

@Service // hérite de @Coponent
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private DaoCustomer daoCustomer;

	public CustomerServiceImpl() {
		System.out.println("dans constructeur daoCustomer = " + daoCustomer);
	}

	@PostConstruct
	public void init() {
		System.out.println("dans la fonction init préfixé par PostConstruct daoCustomer = " + daoCustomer);
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		return this.daoCustomer.save(customer);
	}

	@Override
	public void specifyCustomerLogin(Long personId, String username, String password) {
		Customer customer = this.daoCustomer.findById(personId).orElse(null);
		customer.setUsername(username);
		customer.setPassword(password);
		this.daoCustomer.save(customer);
	}

	@Override
	public Customer findCustomerByUsername(String username) {
		return this.daoCustomer.findByUsername(username);
	}

	@Override
	public boolean checkCustomerPassword(Long personId, String password) {
		Customer customer = this.daoCustomer.findById(personId).orElse(null);
		boolean check;
		if (customer.getPassword().equals(password)) {
			check = true;
		} else {
			check = false;
		}
		return check;

	}

	@Override
	public Customer findCustomerById(Long personId) {
		return this.daoCustomer.findById(personId).orElse(null);
	}

}
