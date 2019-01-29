package fr.m2i.tp.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.m2i.tp.MySpringBootApplication;
import fr.m2i.tp.entity.Customer;
import fr.m2i.tp.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MySpringBootApplication.class })
public class TestCustomerService {

	@Autowired
	private CustomerService customerService;

	@Test
	public void test1_AddNewCustomer() {
		Customer customer = new Customer(null, "Rim", "Khlif", "rimkhlif@ya.com", "05847532", LocalDate.of(1985, 8, 20),
				"1230", "rim");
		this.customerService.addNewCustomer(customer);
		Assert.assertTrue(customer.getId() != null);

	}

	@Test
	public void test2_SpecifyCustomerLogin() {
		Customer customer = new Customer(null, "Rim", "Khlif", "rimkhlif@ya.com", "05847532", LocalDate.of(1985, 8, 20),
				"1230", "rim");
		this.customerService.addNewCustomer(customer);
		this.customerService.specifyCustomerLogin(customer.getId(), "ines", "123");
		Assert.assertTrue(customer.getUsername() != null);
	}

	@Test
	public void test3_FindCustomerByUsername() {
		Customer customer = new Customer(null, "Rim", "Khlif", "rimkhlif@ya.com", "05847532", LocalDate.of(1985, 8, 20),
				"1230", "rim");
		this.customerService.addNewCustomer(customer);
		this.customerService.specifyCustomerLogin(customer.getId(), "ines", "123");
		Customer customerrecup = this.customerService.findCustomerByUsername("ines");
		Assert.assertTrue(customer.getId() == customerrecup.getId());
	}

	@Test
	public void test4_CheckCustomerPassword() {
		Customer customer = new Customer(null, "Rim", "Khlif", "rimkhlif@ya.com", "05847532", LocalDate.of(1985, 8, 20),
				"1230", "rim");
		this.customerService.addNewCustomer(customer);
		String passwordBase = customer.getPassword();
		// this.customerService.specifyCustomerLogin(customer.getId(), "ines", "123");
		System.out.println(this.customerService.checkCustomerPassword(customer.getId(), "1230"));
		Assert.assertTrue(this.customerService.checkCustomerPassword(customer.getId(), "1230"));
	}
}
