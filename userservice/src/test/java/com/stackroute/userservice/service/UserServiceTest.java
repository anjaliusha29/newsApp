package com.stackroute.userservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.services.UserServiceImpl;

public class UserServiceTest {

	private User user;
	
	@Mock
	private transient UserRepository userRepo;
	@InjectMocks
	private UserServiceImpl userServiceimpl;
	@Autowired
	private MockMvc mockMvc;
	transient Optional<User> options;
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(userServiceimpl).build();

     //   user=new User();
		user = Mockito.mock(User.class);
		user.setFirstName("jincy");
		user.setLastName("Job"); 
		user.setUserId("jincy123");
		user.setPassword("jincy123");
	}
	
	@Test
	public void saveUserTest() throws UserAlreadyExistsException
	{
		 
		userServiceimpl.saveUser(user);
		when(userRepo.save(user)).thenReturn(user);
		final boolean flag=userServiceimpl.saveUser(user);
		assertTrue(flag);
		
	}
	
	@Test
	public void findByUserIdAndPasswordTest() throws UserNotFoundException{
		when(userRepo.save(user)).thenReturn(user);
		when(userRepo.findByUserIdAndPassword("jincy123", "jincy123")).thenReturn(user);
		User userDetails=new User();
		userDetails.setUserId("jincy123");
		userDetails.setPassword("jincy123");
		String user_id=userDetails.getUserId();
		String password=userDetails.getPassword();
		userDetails=userServiceimpl.findByUserIdAndPassword(user_id, password);
		Assert.assertEquals(user, userDetails);
		Assert.assertEquals(user.getUserId(),userDetails.getUserId());
	}
	
	@Test(expected=UserNotFoundException.class)
	public void findByUserIdAndPasswordFailure() throws UserNotFoundException{
		
		when(userRepo.findByUserIdAndPassword("jincy1234", "jincy1234")).thenReturn(user);
		
		User userDetails=userServiceimpl.findByUserIdAndPassword("jincy12", "jincy12");
		
		Assert.assertEquals(user, userDetails);
	
	}
	
	
}
