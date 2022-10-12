package com.shopping.admin.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping.admin.user.repository.RoleRepository;
import com.shopping.admin.user.repository.UserRepository;
import com.shopping.common.entity.Role;
import com.shopping.common.entity.User;

@Service("userService")
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder encrypter;
	
	public List<User> fetchAllUsers()
	{
		return (List<User>) userRepo.findAll();
	}
	
	public List<Role> fetchAllRoles()
	{
		return (List<Role>) roleRepo.findAll();
	}
	
	public String saveUserRepo(User userRecord)
	{
		userRepo.save(userRecord);
		return "succesfull";
	}
	
	public void encryptPassword(User user)
	{
		String encrtytedPassword=encrypter.encode(user.getPassword());
		user.setPassword(encrtytedPassword);
	}
	
	public boolean checkEmailInDB(String email)
	{
		Optional<User> userRecord=userRepo.findByEmail(email);
		return userRecord.isPresent();
	}
}
