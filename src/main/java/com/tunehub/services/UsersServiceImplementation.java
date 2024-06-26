package com.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Users;
import com.tunehub.repositories.UsersRepository;
@Service
public class UsersServiceImplementation implements UsersService {

	@Autowired
	UsersRepository repo;


	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "user created and saved";
	}


	@Override
	public boolean emailExists(String email) {
		Users user=repo.findByEmail(email);
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
	}


	@Override
	public boolean validateUser(String email, String password) {
		Users user=repo.findByEmail(email);
		String db_password=user.getPassword();
		if(password.equals(db_password)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public String getRole(String email) {
		Users user=repo.findByEmail(email);
		return user.getRole();
	}


	@Override
	public Users getUsers(String email) {
		return repo.findByEmail(email);
	}


	@Override
	public void updateUser(Users users) {
		repo.save(users);
	}

}
