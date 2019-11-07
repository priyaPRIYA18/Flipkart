package com.example.employee.EmployeeData.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.employee.EmployeeData.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	

}
																										