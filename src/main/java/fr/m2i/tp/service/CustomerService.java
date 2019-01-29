package fr.m2i.tp.service;

import fr.m2i.tp.entity.Customer;

public interface CustomerService {
	public Customer addNewCustomer(Customer customer);

	public void specifyCustomerLogin(Long personId, String username, String password);

	public Customer findCustomerByUsername(String username);

	public boolean checkCustomerPassword(Long personId, String password);

	public Customer findCustomerById(Long personId);
}
