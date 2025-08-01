package training.iqgateway.admin.service;

import java.util.List;

import training.iqgateway.admin.entity.User;

public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getAllUsers();

	public boolean deleteUserById(String id);

	public User findByEmail(String email);

}
