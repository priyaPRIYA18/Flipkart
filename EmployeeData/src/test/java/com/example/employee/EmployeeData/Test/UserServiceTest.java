package com.example.employee.EmployeeData.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.employee.EmployeeData.Repository.UserRepository;
import com.example.employee.EmployeeData.Service.UserService;
import com.example.employee.EmployeeData.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;

	@Autowired
    private UserService userService;
        
        
        @Before
        public void init() {
            MockitoAnnotations.initMocks(this);
        }
     
        @Test
        public void getUsersTest()
        {
            List<User> list = new ArrayList<User>();
            User empOne = new User("priya","priya@gmail.com","bangalore",123445);
            User empTwo = new User("riya","riya@gmail.com","meerut",172245);
            User empThree = new User("himanshi","himanshi@gmail.com","delhi",989898);
             
            list.add(empOne);
            list.add(empTwo);
            list.add(empThree);
            
            when(userRepository.findAll()).thenReturn(list);
            
            //test
            List<User> empList = userService.findAll();
             
            assertEquals(3, empList.size());
            verify(userRepository, times(1)).findAll();
        }
        @Test
      public void createUsersTest()
      {
        	
        	User emp=new User("seema","seema@gmail.com","meerut",13123);
    	  
		/*
		 * User emp=new User("seema","seema@gmail.com","meerut",13123);
		 * userService.create(emp); verify(userRepository, times(1)).save(emp);
		 */
        	
        	Mockito.when(userRepository.save(emp)).thenReturn(emp);
        	
        	assertThat(userService.create(emp)).isEqualTo(emp);
    }
        
        
      @Test
      public void getEmployeeIdTest() {
        	
        	User empOne = new User("priya","priya@gmail.com","bangalore",123445);
        	
        	Mockito.when(userRepository.findById(123445)).thenReturn(Optional.of(empOne));
        	
    	    assertThat(userService.getEmployeeById(123445)).isEqualTo(Optional.of(empOne));
      }
      
      @Test
      public void deleteEmployeeTest() {
    	  User empUser = new User("priya","priya@gmail.com","bangalore",123445);
    	  User empUser1 = new User("himanshi","himanshi@gmail.com","delhi",989898);

//    	  Mockito.when(userRepository.delete(empUser)).thenReturn(empUser1); //expect a fetch, return a "fetched" person;
//
//    	    userService.delete(empUser);
//
//    	    verify(userRepository, times(1)).delete(empUser1);
//    	  
   	  //Mockito.when(userRepository.delete(empUser1)).thenReturn();
 	    Mockito.when(userRepository.existsById(empUser1.getEmployeeId())).thenReturn(false);
 	    assertFalse(userRepository.existsById(empUser1.getEmployeeId()));
    	    
     }
      @	Test
      public void updateEmployeeTest() {
    	  
    	  User empOne = new User("priya","priya@gmail.com","noida",123445);
    	  
//    	  Mockito.when(userRepository.update()).thenReturn(empOne);
    	  
    	    empOne.setLocation("gurgaon");
    	    
  	  Mockito.when(userRepository.save(empOne)).thenReturn(empOne);
  	  
  		
  		assertThat(userService.update(empOne)).isEqualTo(empOne);
  		
  		
      }
      @Test
      public void getAllEmployeeListTest() {
    	  
    	  List<User> userList = new ArrayList<>();
    	  
    	  User empOne = new User("priya","priya@gmail.com","bangalore",123445);
      	User empTwo=new User("neha","neha12@gmail.com","noida",12332);
      	  userList.add(empOne);
      	  userList.add(empTwo);
      	  
Mockito.when(userRepository.findAll()).thenReturn(userList);
		
		assertThat(userService.findAll()).isEqualTo(userList);
    	  
      }
      
}
     
        

             
