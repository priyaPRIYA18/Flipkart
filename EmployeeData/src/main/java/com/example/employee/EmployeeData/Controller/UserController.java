package com.example.employee.EmployeeData.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.EmployeeData.Repository.UserRepository;
import com.example.employee.EmployeeData.Service.UserService;
import com.example.employee.EmployeeData.pojo.User;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;


	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.findAll();

	}

	
	@PostMapping("/employees")	
	public User create(@RequestBody User u) {
		return userService.create(u);
	}

	@PutMapping("/empUpdate")
	public User update(@RequestBody User user) {
		return userService.create(user);
	}

     @DeleteMapping("/delUsers/{employeeId}")
     public void deleteUser(@PathVariable int employeeId) {
	    userService.delete(employeeId);
	   }
	
	/*
	 * @DeleteMapping("/{employeeId}") public ResponseEntity<String >
	 * deleteCustomer(@PathVariable("employeeId") int employeeId ){
	 * System.out.println("Delete Employee with ID = " + employeeId + "...");
	 * 
	 * userRepository.deleteById(employeeId);
	 * 
	 * return new ResponseEntity<>("Employee has been deleted!", HttpStatus.OK); }
	 */
	
	

	@DeleteMapping("/users/deleteAll")
	public void deleteAll() {
		userService.deleteAll();
	}
//	    @RequestMapping("/getUser")
//	    public List<User> getUser (@RequestParam int employeeId,@RequestParam String location){
//	    	System.out.println("in controlletr getUser");
//	    	return UserService.getUser(employeeId,location);
//	    }
}