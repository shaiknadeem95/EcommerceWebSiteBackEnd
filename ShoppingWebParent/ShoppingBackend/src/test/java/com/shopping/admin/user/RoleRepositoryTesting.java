package com.shopping.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopping.admin.user.repository.RoleRepository;
import com.shopping.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class RoleRepositoryTesting {

	@Autowired
	RoleRepository roleRepo;
	
	@Test
	public void testCreatFirstRole()
	{
		Role role =new Role("Admin","manage Everything"); 
		Role savedRole=roleRepo.save(role);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testOtherRoles()
	{
		Role roleSales=new Role("SalesPerson","manage product price, "
				+ "customer, shipping, order and sales report");
		Role roleEditor=new Role("Editor","manage product, customers, shipping, "
				+ "orders and sales report");
		Role roleShippers=new Role("Shipper","view products, view orders and "
				+ "update order status");
		roleRepo.saveAll(List.of(roleSales,roleEditor,roleShippers));
	}
}
