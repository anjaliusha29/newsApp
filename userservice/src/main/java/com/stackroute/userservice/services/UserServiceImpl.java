package com.stackroute.userservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		
		Optional<User> u1 = userRepo.findById(user.getUserId());
		if(u1.isPresent()) {
			throw new UserAlreadyExistsException("User with Id already exists");
		}
		userRepo.save(user);
		
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		
		User user = userRepo.findByUserIdAndPassword(userId, password);
		if(user == null) {
			throw new UserNotFoundException("UserId and Password mismatch");
		}
		return user;
	}
	
	@Override
	public User updateUser(User user,String userId) throws UserNotFoundException {
		try {
		Optional<User> user1= userRepo.findById(userId);
			if(user1.isPresent()) {	
				user1.get().setFirstName(user.getFirstName());
				user1.get().setLastName(user.getLastName());
				user1.get().setPassword(user.getPassword());
				user1.get().setCreatedDate(user1.get().getCreatedDate());
				User user2=user1.get();
				userRepo.save(user2);
				
				return user2;
			}
			else
			{
				return null;
			}
			
	   }catch(Exception e) {
		e.printStackTrace();
		throw e;
	  }
		
	}
	
		
	@Override
	public User viewUser(String userId) throws UserNotFoundException {
		try {
		Optional<User> user1= userRepo.findById(userId);
			if(user1.isPresent()) {	
				User user2=user1.get();
				return user2;
			}
			else
			{
				return null;
			}
			
	   }catch(Exception e) {
		e.printStackTrace();
		throw e;
	  }
		
	}
		
}

