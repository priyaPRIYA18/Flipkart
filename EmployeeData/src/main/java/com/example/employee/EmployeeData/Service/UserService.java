package com.example.employee.EmployeeData.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.employee.EmployeeData.Repository.UserRepository;
import com.example.employee.EmployeeData.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User create(User u) {
		return userRepository.save(u);
	}

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User update(User user) {
		return userRepository.save(user);

	}

	public String delete(int employeeId) {
		userRepository.deleteById(employeeId);
		return "ID DELETED";
	}
	
public Optional<User> getEmployeeById(int employeeId) {
	return userRepository.findById(employeeId);
}



	public void deleteAll() {
		userRepository.deleteAll();
	}
//	public Optional<User> getEmailId(String emailId){
//		return userRepository.findAll(emailId);
//	}
//public List<User> getAll(int employeeId,String location){
//	List<User> list=UserService.getUser(employeeId,location);
//	
//	List<User> wantendUser=new ArrayList<>();
//

	
}
