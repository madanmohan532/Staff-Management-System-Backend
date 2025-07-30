package training.iqgateway.service;

import java.util.List;

import training.iqgateway.entity.Users;

public interface UserService {
	
	Users findByEmail(String email);

	List<Users> findAll();
}
