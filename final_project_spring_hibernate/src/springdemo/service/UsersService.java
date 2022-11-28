package springdemo.service;

import java.util.List;

import springdemo.entity.Users;

public interface UsersService {
	public void registerUsers(Users user);
	public Users login(Users user);
	public List<Users> getUsers();
	public Users getUser(int user_id);
}
