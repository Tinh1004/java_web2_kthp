package springdemo.dao;

import java.util.List;

import springdemo.entity.Products;
import springdemo.entity.Users;

public interface UsersDAO {
	public void registerUsers(Users user);
	public Users login(Users user);
	public List<Users> getUsers();
	public Users getUser(int user_id);
}
